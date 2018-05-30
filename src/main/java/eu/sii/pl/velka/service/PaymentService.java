package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;

public interface PaymentService {
    AuthorisationEffect trySendPayment(PaymentDeclaration paymentDeclaration);
    PaymentPlan getPaymentPlan(PaymentDeclaration paymentDeclaration);
}
