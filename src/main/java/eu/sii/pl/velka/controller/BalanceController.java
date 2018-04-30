package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class BalanceController {
    private static String API_URL="http://ec2-34-252-93-5.eu-west-1.compute.amazonaws.com/micuenta/balance?ssn=980-122-111";

    public static Debtor getDebtorBalance(){
        RestTemplate restTemplate=new RestTemplate();
        Debtor debtor=restTemplate.getForObject(API_URL, Debtor.class);
              ResponseEntity<String> response = restTemplate.getForEntity(
                    API_URL, String.class);
        return debtor;

}}
