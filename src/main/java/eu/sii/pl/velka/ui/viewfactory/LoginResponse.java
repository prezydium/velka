package eu.sii.pl.velka.ui.viewfactory;

import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.service.BalanceService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginResponse implements ResponseTargetI {

    @Autowired
    BalanceService balanceService;

    @Override
    public void execute(ActiveMQTextMessage textMessage) {
        Debtor debtor = (Debtor) UI.getCurrent().getSession().getAttribute("debtor");
        balanceService.getFullData(debtor.getSsn());
    }
}
