package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.PaymentConfirmation;

public interface PaymentConfirmationService {
    boolean sendPaymentConfirmation(PaymentConfirmation paymentConfirmation);
}
