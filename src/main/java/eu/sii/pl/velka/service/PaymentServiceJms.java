package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class PaymentServiceJms implements PaymentService {

    private final Logger LOG = LoggerFactory.getLogger(PaymentServiceJms.class);

    @Value("${queue.login}")
    private final Queue queue;

    private final JmsMessagingTemplate jmsTemplate;

    @Autowired
    public PaymentServiceJms(Queue queue, JmsMessagingTemplate jmsTemplate) {
        this.queue = queue;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public AuthorisationEffect trySendPayment(PaymentDeclaration paymentDeclaration) {
        throw new UnsupportedOperationException();
        }

    @Override
    public PaymentPlan getPaymentPlan(PaymentDeclaration paymentDeclaration) {
        throw new UnsupportedOperationException();
    }
}
