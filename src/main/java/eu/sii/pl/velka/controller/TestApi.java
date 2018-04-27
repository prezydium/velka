package eu.sii.pl.velka.controller;


import eu.sii.pl.velka.GenerateRandomData;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {


    @RequestMapping(value = "/test")

    public Debtor getDebtor(){

            return new GenerateRandomData().generateDebtor();

    }




}
