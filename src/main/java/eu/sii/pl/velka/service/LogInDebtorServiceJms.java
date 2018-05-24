package eu.sii.pl.velka.service;

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
public class LogInDebtorServiceJms implements LogInDebtorService {

    private final static Logger LOG = LoggerFactory.getLogger(LogInDebtorServiceJms.class);

    @Value("${queue.login}")
    private final Queue queue;

    private final JmsMessagingTemplate jmsTemplate;

    @Autowired
    public LogInDebtorServiceJms(Queue queue, JmsMessagingTemplate jmsTemplate) {
        this.queue = queue;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public AuthorisationEffect confirmThatDebtorExists(Debtor debtor) {
        throw new UnsupportedOperationException();
        //TODO wil be implemented in JAV-103
    }
}
