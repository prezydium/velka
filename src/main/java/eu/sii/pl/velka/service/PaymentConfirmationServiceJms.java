package eu.sii.pl.velka.service;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.jms.producer.Sender;
import eu.sii.pl.velka.model.PaymentConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jms")
@UIScope
public class PaymentConfirmationServiceJms implements PaymentConfirmationService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentConfirmationServiceJms.class);

    @Value("${queue.paymentsupdate}")
    private String queue;

    @Autowired
    private Sender sender;

    @Override
    public boolean sendPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        sender.send(queue, paymentConfirmation, UI.getCurrent().getEmbedId());
        return true;
    }
}
