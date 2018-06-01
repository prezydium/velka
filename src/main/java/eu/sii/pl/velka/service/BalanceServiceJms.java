package eu.sii.pl.velka.service;

import eu.sii.pl.velka.jms.producer.Sender;
import eu.sii.pl.velka.model.Debtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
@Profile("jms")
public class BalanceServiceJms implements BalanceService {

    private final static Logger LOG = LoggerFactory.getLogger(BalanceServiceJms.class);

    @Value("${queue.balance}")
    private String queue;

    @Autowired
    private Sender sender;

    @Override
    public Debtor getFullData(String ssn) {
        sender.convertAndsend(queue,ssn);
        return new Debtor();
    }
}
