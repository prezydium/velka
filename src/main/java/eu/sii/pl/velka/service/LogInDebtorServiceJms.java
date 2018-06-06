package eu.sii.pl.velka.service;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import eu.sii.pl.velka.jms.producer.Sender;
import eu.sii.pl.velka.model.Debtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jms")
@SpringComponent
@UIScope
public class LogInDebtorServiceJms implements LogInDebtorService {

    private final static Logger LOG = LoggerFactory.getLogger(LogInDebtorServiceJms.class);

    @Value("${queue.login}")
    private String queue;

    @Autowired
    private Sender sender;

    @Override
    public AuthorisationEffect confirmThatDebtorExists(Debtor debtor) {
        sender.convertAndsend(queue, debtor);
        return AuthorisationEffect.WAITING;
    }
}
