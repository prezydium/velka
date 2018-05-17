package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.PaymentConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PaymentConfirmationController {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentConfirmationController.class);

    private RestTemplate restTemplate;

    @Value("${api_url}")
    private String API_URL;

    private final String API_URL_PAYMENT_CONFIRMATION = "paymentmethods/creditcard/";

    @Autowired
    public PaymentConfirmationController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean sendPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        try {
            ResponseEntity response = restTemplate.postForEntity(
                    API_URL + API_URL_PAYMENT_CONFIRMATION, paymentConfirmation, PaymentConfirmation.class);
            logSuccessfulPayment(paymentConfirmation);
            return true;
        } catch (Exception e) {
            LOG.error("Failed to make payment" + e.getMessage());
            return false;
        }
    }

    private void logSuccessfulPayment(PaymentConfirmation paymentConfirmation) {
        LOG.info("Payment successful: "
                + paymentConfirmation.getPaymentDeclaration().getDebtUuid()
                + paymentConfirmation.getPaymentDeclaration().getPaymentAmount());

    }
}
