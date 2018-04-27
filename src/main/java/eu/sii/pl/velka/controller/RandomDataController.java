package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class RandomDataController {

private static final String API_URL="http://localhost:8080/test";

    public static Debtor getDebtorBalance(){

        RestTemplate restTemplate=new RestTemplate();
        Debtor debtor=restTemplate.getForObject(API_URL, Debtor.class);

        return debtor;


    }



}
