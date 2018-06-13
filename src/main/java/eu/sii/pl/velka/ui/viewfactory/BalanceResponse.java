package eu.sii.pl.velka.ui.viewfactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.service.BalanceServiceRest;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceResponse implements ResponseTargetI {

    private final static Logger LOG = LoggerFactory.getLogger(BalanceResponse.class);

    private final ObjectMapper objectMapper;

    @Autowired
    public BalanceResponse(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void execute(ActiveMQTextMessage textMessage) {
        Debtor debtor = null;
        try {
            debtor = objectMapper.readValue(textMessage.getText(), Debtor.class);
            UI.getCurrent().getSession().setAttribute("debtor", debtor);
        } catch (Exception e) {
            LOG.error("Error switching view during BalanceResponse: " + e.getMessage());
        }
    }
}
