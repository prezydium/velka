package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DebtorController {

    public HttpStatus confirmThatDebtorExists(Debtor debtor) {
        RestTemplate restTemplate = new RestTemplate();
        String testResourceUrl = "http://localhost:8090/login"; //test
        ResponseEntity<Debtor> response = restTemplate.postForEntity(testResourceUrl, debtor, Debtor.class);
        return response.getStatusCode();
    }
}
