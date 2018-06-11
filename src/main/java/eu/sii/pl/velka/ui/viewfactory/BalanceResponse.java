package eu.sii.pl.velka.ui.viewfactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceResponse implements ResponseTargetI {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void execute(ActiveMQTextMessage textMessage) {
        Debtor debtor = null;
        try {
            debtor = objectMapper.readValue(textMessage.getText(), Debtor.class);
            UI.getCurrent().getSession().setAttribute("debtor", debtor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
