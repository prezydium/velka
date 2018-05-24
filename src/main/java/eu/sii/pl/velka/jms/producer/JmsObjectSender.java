package eu.sii.pl.velka.jms.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import eu.sii.pl.velka.converters.SsnConverter;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.service.AuthorisationEffect;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.MessageNotWriteableException;


@SpringComponent
@UIScope
public class JmsObjectSender {

    @Autowired
    Sender sender;

    public void sendObject(String queue, Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
            ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText(json);
            textMessage.setCorrelationId("velka");
            sender.send(queue, textMessage);
        } catch (JsonProcessingException | JMSException e) {
            e.printStackTrace();
        }
    }

//    public void sentDebtorToAPI(Debtor debtor) {
//        debtor.setSsn(new SsnConverter().convertSsnToFormatAcceptableByAPI(debtor.getSsn()));
//
//        if (authorisationEffect == AuthorisationEffect.RECOGNISED) {
//            debtor = balanceService.getFullData(debtor.getSsn());
//            VaadinSession.getCurrent().setAttribute("debtor", debtor);
//            springNavigator.navigateTo("balance");
//        }
//    }
}
