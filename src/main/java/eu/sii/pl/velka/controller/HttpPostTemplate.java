package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;

import org.springframework.web.client.RestTemplate;


public class HttpPostTemplate {

    public static Debtor fetchDataGET(){

        RestTemplate restTemplate=new RestTemplate();
        Debtor debtor=restTemplate.getForObject("http://localhost:8080/test", Debtor.class);

        return debtor;


    }



}
