package eu.sii.pl.velka.jms.receiver;

import com.vaadin.spring.annotation.SpringComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@SpringComponent
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private String json;
    private String endpoint;

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }


    @JmsListener(destination = "jms.queue.velka")
    public void receiveMessage(TextMessage message) {
        LOGGER.info("received message='{}'", message);
        try {
            setJson(message.getText());
            setEndpoint(message.getStringProperty("endpoint"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
