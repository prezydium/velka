package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceRest implements PaymentService {

    @Value("${api_url}")
    private String API_URL;

    private final String API_URL_Payment = "paymentplan";

    private RestTemplate restTemplate;

    private final Logger LOG = LoggerFactory.getLogger(PaymentServiceRest.class);

    @Autowired
    public PaymentServiceRest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public AuthorisationEffect trySendPayment(PaymentDeclaration paymentDeclaration) {
        try {
            ResponseEntity<PaymentPlan> response = restTemplate.postForEntity(API_URL + API_URL_Payment, paymentDeclaration, PaymentPlan.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                LOG.info("Sent payment declaration with httpstatus OK");
                return AuthorisationEffect.RECOGNISED;
            }
        } catch (Exception e) {
            LOG.error("Error connecting to server " + e.getMessage());
        }
        return AuthorisationEffect.ERROR;
    }

    @Override
    public PaymentPlan getPaymentPlan(PaymentDeclaration paymentDeclaration) {
        String paymentUrl = API_URL + API_URL_Payment;
        PaymentPlan paymentPlan = new PaymentPlan();
        try {
            ResponseEntity<PaymentPlan> response = restTemplate.postForEntity(paymentUrl, paymentDeclaration, PaymentPlan.class);
            LOG.info("Geting Payment Plan from API");
            return response.getBody();
        } catch (Exception e) {
            LOG.error("Error connecting to server: " + e.getMessage());
        }
        return paymentPlan;
    }
}
