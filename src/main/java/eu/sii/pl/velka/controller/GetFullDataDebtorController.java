package eu.sii.pl.velka.controller;

import com.vaadin.spring.annotation.SpringComponent;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import java.util.logging.Logger;

@Controller
public class GetFullDataDebtorController {

    private final Logger LOG = Logger.getLogger(LogInDebtorController.class.getName());

    private RestTemplate restTemplate;

    @Value("${api_url}")
    private String API_URL;

    @Value("${get_debtor_endpoint}")
    private String API_URL_GET_DEBTOR;

    @Autowired
    public GetFullDataDebtorController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    Debtor getFullData(String ssn) {
        String urlWithGet = API_URL + API_URL_GET_DEBTOR + ssn;
        Debtor localDebtor = restTemplate.getForObject(urlWithGet, Debtor.class);
        return localDebtor;
    }

}
