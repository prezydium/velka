package eu.sii.pl.velka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.sii.pl.velka.jms.Sender;
import eu.sii.pl.velka.model.Debtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Queue;

@Service
@Profile("jms")
public class LogInDebtorServiceJms implements LogInDebtorService {

    private final static Logger LOG = LoggerFactory.getLogger(LogInDebtorServiceJms.class);

    @Value("${queue.login}")
    private String queue;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private Sender sender;

    @Override
    public AuthorisationEffect confirmThatDebtorExists(Debtor debtor) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(debtor);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            sender.send(queue, json);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return AuthorisationEffect.WAITING;
    }
}
