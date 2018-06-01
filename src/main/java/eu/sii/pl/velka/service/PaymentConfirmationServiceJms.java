package eu.sii.pl.velka.service;

import eu.sii.pl.velka.jms.producer.Sender;
import eu.sii.pl.velka.model.PaymentConfirmation;
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
public class PaymentConfirmationServiceJms implements PaymentConfirmationService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentConfirmationServiceJms.class);

    @Value("${queue.paymentsupdate}")
    private String queue;

    @Autowired
    private Sender sender;

    @Override
    public boolean sendPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        sender.convertAndsend(queue, paymentConfirmation);
        return true;
    }
}
