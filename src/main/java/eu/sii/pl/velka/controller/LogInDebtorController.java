package eu.sii.pl.velka.controller;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LogInDebtorController {

    private final Logger LOG = Logger.getLogger(LogInDebtorController.class.getName());

    private RestTemplate restTemplate;

    private String navigationTarget = "";

    @Value("${api_url}")
    private String API_URL;

    private GetFullDataDebtorController getFullDataDebtorController;

    @Autowired
    public LogInDebtorController(RestTemplateBuilder restTemplateBuilder) {
        this.getFullDataDebtorController = getFullDataDebtorController;
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getAPI_URL() {
        return API_URL;
    }

    public AuthorisationEffect confirmThatDebtorExists(Debtor debtor) {
        try {
            ResponseEntity response = restTemplate.postForEntity(API_URL, debtor, Debtor.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return AuthorisationEffect.RECOGNISED;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                LOG.log(Level.INFO, "Debtor not found: " + debtor.toString());
                return AuthorisationEffect.NOT_RECOGNISED;
            } else {
                LOG.log(Level.WARNING, "Error, http status code: " + e.getStatusCode().toString());
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error connecting to server");
        }
        return AuthorisationEffect.ERROR;
    }
}
