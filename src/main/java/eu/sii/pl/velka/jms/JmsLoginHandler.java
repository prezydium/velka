package eu.sii.pl.velka.jms;

import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public class JmsLoginHandler {

    @Autowired
    private Sender sender;

    public void sendSsn(String ssn) throws JMSException {
        sender.send("jms.queue.balance", ssn);
    }
}
