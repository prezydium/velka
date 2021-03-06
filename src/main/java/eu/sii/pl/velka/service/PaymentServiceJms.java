package eu.sii.pl.velka.service;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.jms.producer.Sender;
import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jms")
public class PaymentServiceJms implements PaymentService {

    private final Logger LOG = LoggerFactory.getLogger(PaymentServiceJms.class);

    @Value("${queue.paymentplan}")
    private String queue;

    private Sender sender;

    @Autowired
    public PaymentServiceJms(Sender sender) {
        this.sender = sender;
    }

    @Override
    public AuthorisationEffect trySendPayment(PaymentDeclaration paymentDeclaration) {
        sender.send(queue, paymentDeclaration);
        return AuthorisationEffect.WAITING;
    }

    @Override
    public PaymentPlan getPaymentPlan(PaymentDeclaration paymentDeclaration) {
       throw new UnsupportedOperationException();
    }
}
