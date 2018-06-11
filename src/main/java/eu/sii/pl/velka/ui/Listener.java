package eu.sii.pl.velka.ui;

import com.vaadin.ui.UI;
import eu.sii.pl.velka.ui.viewfactory.ResponseFactory;
import eu.sii.pl.velka.ui.views.JmsResponseSwitch;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.IOException;
import java.util.Map;

@Component
public class Listener {

    private final static Logger LOG = LoggerFactory.getLogger(VelkaUIJms.class);
    @Autowired
    private SessionMap sessionMap;

    @Autowired
    ResponseFactory responseFactory;

    private Map<String, String> reactionForJms = JmsResponseSwitch.fillMap();

    @JmsListener(destination = "jms.queue.velka")
    public void consume(ActiveMQTextMessage textMessage) {
        UI ui = sessionMap.getUiFromStorage("4");
        ui.accessSynchronously(() -> {
            try {
                String responseTarget = (String) textMessage.getProperty("endpoint");
                String navigationTarget = reactionForJms.get(responseTarget);
                LOG.info("receiving message='{}' to destination='{}'", textMessage.getText());
                responseFactory.getResponse(responseTarget).execute(textMessage);
                ui.getNavigator().navigateTo(navigationTarget);
            } catch (JMSException | IOException e) {
                LOG.error("Error receiving jms message: " + e.getMessage());
            }
        });
    }
}
