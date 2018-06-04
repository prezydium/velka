package eu.sii.pl.velka.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.service.BalanceService;
import eu.sii.pl.velka.ui.authorisation.ErrorView;
import eu.sii.pl.velka.ui.authorisation.SuccessfulLoginView;
import eu.sii.pl.velka.ui.views.JmsResponseSwitch;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

@SpringUI
@Theme("valo")
@SpringViewDisplay
@Push
public class VelkaUI extends UI {

    private final static Logger LOG = LoggerFactory.getLogger(VelkaUI.class);

    @Autowired
    private BalanceService balanceService;

    private ObjectMapper objectMapper;

    public VelkaUI(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");
        getNavigator().setErrorView(ErrorView.class);
    }

    private Map<String, String> reactionForJms = JmsResponseSwitch.fillMap();

    @JmsListener(destination = "jms.queue.velka")
    public void consume(ActiveMQTextMessage textMessage) {
        objectMapper.configure(SerializationFeature.CLOSE_CLOSEABLE.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        this.accessSynchronously(() -> {
            try {
                String responseTarget = (String) textMessage.getProperty("endpoint");
                String navigationTarget = reactionForJms.get(responseTarget);
                LOG.info("receiving message='{}' to destination='{}'", textMessage.getText());
                if (responseTarget.equals("login")) {
                    Debtor debtor = (Debtor) UI.getCurrent().getSession().getAttribute("debtor");
                    balanceService.getFullData(debtor.getSsn());
                } else if (responseTarget.equals("balance")) {
                    Debtor debtor = objectMapper.readValue(textMessage.getText(), Debtor.class);
                    UI.getCurrent().getSession().setAttribute("debtor", debtor);
                } else if (responseTarget.equals("paymentplan")) {
                    PaymentPlan paymentPlan = objectMapper.readValue(textMessage.getText(), PaymentPlan.class);
                    UI.getCurrent().getSession().setAttribute("paymentPlan", paymentPlan);
                } else if (responseTarget.equals("paymentsupdate")) {
                    getNavigator().navigateTo(SuccessfulLoginView.VIEW_NAME);
                }
                getNavigator().navigateTo(navigationTarget);
            } catch (JMSException | IOException e) {
                LOG.error("Error receiving jms message: " + e.getMessage());
            }
        });
    }
}
