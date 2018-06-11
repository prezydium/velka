package eu.sii.pl.velka.jms.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.service.BalanceService;
import eu.sii.pl.velka.session.SessionMap;
import eu.sii.pl.velka.ui.VelkaUIJms;
import eu.sii.pl.velka.ui.views.JmsResponseSwitch;
import eu.sii.pl.velka.ui.views.SuccessfulPaymentView;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Component
public class VelkaJmsListener {

    private Map<String, String> reactionForJms = JmsResponseSwitch.fillMap();

    private final static Logger LOG = LoggerFactory.getLogger(VelkaUIJms.class);

    @Autowired
    private SessionMap sessionMap;

    private ObjectMapper objectMapper;

    public VelkaJmsListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @JmsListener(destination = "jms.queue.velka")
    public void consume(ActiveMQTextMessage textMessage) {
        objectMapper.configure(SerializationFeature.CLOSE_CLOSEABLE.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        try {
            String responseTarget = (String) textMessage.getProperty("endpoint");
            String uiEmbededId = textMessage.getCorrelationId();

            UI ui = sessionMap.getUiFromStorage(uiEmbededId);
            String navigationTarget = reactionForJms.get(responseTarget);
            LOG.info("receiving message='{}' to destination='{}'", textMessage.getText());

            if (responseTarget.equals("balance")) {
                Debtor debtor = objectMapper.readValue(textMessage.getText(), Debtor.class);
                ui.getSession().setAttribute("debtor", debtor);
            } else if (responseTarget.equals("paymentplan")) {
                PaymentPlan paymentPlan = objectMapper.readValue(textMessage.getText(), PaymentPlan.class);
                ui.getSession().setAttribute("paymentPlan", paymentPlan);
            }
            ui.getNavigator().navigateTo(navigationTarget);
        } catch (JMSException | IOException e) {
            LOG.error("Error receiving jms message: " + e.getMessage());
        }
    }
}
