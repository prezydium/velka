package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class BalanceController {

    private final Logger LOG = Logger.getLogger(BalanceController.class.getName());

    private static String API_URL = "http://ec2-34-252-93-5.eu-west-1.compute.amazonaws.com/micuenta/balance?ssn=";

    public Debtor getDebtorBalance(String ssn) {

        String GET_URL = API_URL + ssn;
        RestTemplate restTemplate = new RestTemplate();
        try {
            Debtor debtor = restTemplate.getForObject(GET_URL, Debtor.class);
            return debtor;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Error connecting to server");
            return null;
        }
    }
}