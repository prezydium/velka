package eu.sii.pl.velka.jms.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;

@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination, Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
            ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText(json);
            textMessage.setStringProperty("client", "velka");
            jmsTemplate.send(destination, (Session session) -> {
                return textMessage;
            });
            LOGGER.info("sending message='{}' to destination='{}'", object.toString(), destination);
        } catch (JsonProcessingException | JMSException e) {
            e.printStackTrace();
        }
    }
}


