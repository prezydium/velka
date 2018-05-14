package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PaymentController {

    @Value("${api_url}")
    private String API_URL;

    @Value("${paymentPlan_endpoint}")
    private String API_URL_Payment;

    private RestTemplate restTemplate;

    private final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    public PaymentController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    PaymentPlan getPaymentPlan(PaymentDeclaration paymentDeclaration) {
        String paymentUrl = API_URL + API_URL_Payment;
        PaymentPlan paymentPlan= new PaymentPlan();
        try{
        ResponseEntity<PaymentPlan> response = new RestTemplate().postForEntity(paymentUrl, paymentDeclaration, PaymentPlan.class);
        LOG.info("Geting Payment Plan from API");
        return response.getBody();
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
            LOG.error("Error connecting to server");
        }
        return paymentPlan;
    }
}
