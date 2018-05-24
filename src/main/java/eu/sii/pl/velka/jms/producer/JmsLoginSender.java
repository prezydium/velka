package eu.sii.pl.velka.jms.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import eu.sii.pl.velka.model.Debtor;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;


@SpringComponent
@UIScope
public class JmsLoginSender {

    @Autowired
    Sender sender;

    public void sendDebtor(String queue, Debtor debtor) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(debtor);
            ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText(json);
            textMessage.setCorrelationId("Velka");
            sender.send(queue, textMessage);
        } catch (JsonProcessingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
