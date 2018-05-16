package eu.sii.pl.velka.controller;


import eu.sii.pl.velka.model.PaymentConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PaymentConfirmationController {

    private RestTemplate restTemplate;

    @Autowired
    public PaymentConfirmationController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void sendPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        ResponseEntity response = restTemplate.postForEntity(
                "http://ec2-34-252-93-5.eu-west-1.compute.amazonaws.com/paymentmethods/creditcard"
                , paymentConfirmation, PaymentConfirmation.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("GREAT SUCCESS");
            System.out.println(paymentConfirmation.toString());
        } else {
            System.out.println("FAIL");
        }
    }

}
