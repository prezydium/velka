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


    public void sendPaymentConfirmation(PaymentConfirmation paymentConfirmation) throws Exception {
        ResponseEntity response = restTemplate.postForEntity(
                "http://ec2-34-252-93-5.eu-west-1.compute.amazonaws.com/api-payment-methods-creditcard-endpoint=/paymentmethods/creditcard"
                , paymentConfirmation, PaymentConfirmation.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("GREAT SUCCESS");
        } else {
            System.out.println("FAIL");
        }
    }

}

/*    AuthorisationEffect confirmThatDebtorExists(Debtor debtor) {
        try {
            ResponseEntity response = restTemplate.postForEntity((API_URL + API_URL_LOGIN), debtor, Debtor.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                LOG.info("Login successful :" + debtor.getFirstName() + " " + debtor.getLastName());
                return AuthorisationEffect.RECOGNISED;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                LOG.warn("Debtor not found: " + debtor.toString());
                return AuthorisationEffect.NOT_RECOGNISED;
            } else {
                LOG.error("Error, http status code: " + e.getStatusCode().toString());
            }
        } catch (Exception e) {
            LOG.error("Error connecting to server: " + e.getMessage());
        }
        return AuthorisationEffect.ERROR;*/