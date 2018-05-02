package eu.sii.pl.velka.controller;

import com.vaadin.spring.annotation.SpringComponent;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import java.util.logging.Logger;

@SpringComponent
@RequestScope
public class GetFullDataDebtorController {

    private final Logger LOG = Logger.getLogger(LogInDebtorController.class.getName());

    private RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Value("${api_get_debtor_url}")
    private String API_URL;

    @RequestMapping("/get-data")
    public Debtor getFullData(String ssn) {
        String urlWithGet = API_URL + ssn;

        Debtor debtor = restTemplate.getForObject("http://ec2-34-252-93-5.eu-west-1.compute.amazonaws.com/micuenta/balance?ssn=980-122-111", Debtor.class);
        System.out.println(debtor.getDebts() + debtor.getLastName());
        return debtor;
    }

}
