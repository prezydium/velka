package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.PaymentConfirmation;
import eu.sii.pl.velka.model.PaymentDeclaration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentConfirmationServiceTest {

    @Autowired
    private PaymentConfirmationService paymentConfirmationService;


    private PaymentConfirmation paymentConfirmation = new PaymentConfirmation(null, null);

    private PaymentDeclaration paymentDeclaration =new PaymentDeclaration();


    @Test
    public void sendPaymentConfirmation() {
    }
}