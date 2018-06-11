package eu.sii.pl.velka.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.ui.authorisation.ErrorView;
import eu.sii.pl.velka.ui.viewfactory.ResponseFactory;
import eu.sii.pl.velka.ui.views.JmsResponseSwitch;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import java.io.IOException;
import java.util.Map;

@SpringUI
@Theme("valo")
@SpringViewDisplay
@Push
@Profile("jms")
public class VelkaUIJms extends UI {

    private final static Logger LOG = LoggerFactory.getLogger(VelkaUIJms.class);

    @Autowired
    ResponseFactory responseFactory;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");
        getNavigator().setErrorView(ErrorView.class);
    }

    private Map<String, String> reactionForJms = JmsResponseSwitch.fillMap();

    @JmsListener(destination = "jms.queue.velka")
    public void consume(ActiveMQTextMessage textMessage) {

        this.accessSynchronously(() -> {
            try {
                String responseTarget = (String) textMessage.getProperty("endpoint");
                String navigationTarget = reactionForJms.get(responseTarget);
                LOG.info("receiving message='{}' to destination='{}'", textMessage.getText());
                responseFactory.getResponse(responseTarget).execute(textMessage);
                getNavigator().navigateTo(navigationTarget);
            } catch (JMSException | IOException e) {
                LOG.error("Error receiving jms message: " + e.getMessage());
            }
        });
    }
}
