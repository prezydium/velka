package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;



@Controller
public class BalanceController {

    private final Logger LOG = LoggerFactory.getLogger(LogInDebtorController.class);

    private RestTemplate restTemplate;

    @Value("${api_url}")
    private String API_URL;

    @Value("${get_debtor_endpoint}")
    private String API_URL_GET_DEBTOR;

    @Autowired
    public BalanceController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    Debtor getFullData(String ssn) {
        String urlWithGet = API_URL + API_URL_GET_DEBTOR + ssn;
        Debtor localDebtor = new Debtor();
        try {
            localDebtor = restTemplate.getForObject(urlWithGet, Debtor.class);
        } catch (Exception e){
            LOG.error("Error getting debtor data" + e.getMessage());
        }
        return localDebtor;
    }
}
