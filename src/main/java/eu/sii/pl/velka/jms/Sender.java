package eu.sii.pl.velka.jms;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination, String json) throws JMSException {

        TextMessage textMessage = new ActiveMQTextMessage();
        ((ActiveMQTextMessage) textMessage).setStringProperty("client", "velka");
        try {
            textMessage.setText(json);
            LOGGER.info("sending message='{}' to destination='{}'", json, destination);
            jmsTemplate.convertAndSend(destination, textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}