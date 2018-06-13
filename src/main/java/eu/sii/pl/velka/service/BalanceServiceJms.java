package eu.sii.pl.velka.service;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.jms.producer.Sender;
import eu.sii.pl.velka.model.Debtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("jms")
public class BalanceServiceJms implements BalanceService {

    private final static Logger LOG = LoggerFactory.getLogger(BalanceServiceJms.class);

    @Value("${queue.balance}")
    private String queue;

    private final Sender sender;

    @Autowired
    public BalanceServiceJms(Sender sender) {
        this.sender = sender;
    }

    @Override
    public Debtor getFullData(String ssn) {
        sender.send(queue, ssn);
        return new Debtor();
    }
}
