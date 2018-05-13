package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class PaymentController {

    @Value("${api_url}")
    private String API_URL;

    @Value("${paymentPlan_endpoint}")
    private String API_URL_Payment;


    private final Logger LOG = Logger.getLogger(LogInDebtorController.class.getName());

    private RestTemplate restTemplate;

    AuthorisationEffect trySendPayment(PaymentDeclaration paymentDeclaration) {
        try {
            ResponseEntity<PaymentPlan> response = new RestTemplate().postForEntity(API_URL + API_URL_Payment, paymentDeclaration, PaymentPlan.class);
            PaymentPlan Paymantplan = response.getBody();
            if (response.getStatusCode() == HttpStatus.OK) {
                return AuthorisationEffect.RECOGNISED;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            LOG.log(Level.SEVERE, "Error connecting to server");
        }
        return AuthorisationEffect.ERROR;
    }

    PaymentPlan getPaymentPlan(PaymentDeclaration paymentDeclaration) {
        ResponseEntity<PaymentPlan> response = new RestTemplate().postForEntity(API_URL + API_URL_Payment, paymentDeclaration, PaymentPlan.class);
        return response.getBody();
    }

}
