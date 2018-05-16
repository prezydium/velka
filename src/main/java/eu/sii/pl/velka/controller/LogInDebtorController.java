package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Controller
public class LogInDebtorController {

    private final static Logger LOG = LoggerFactory.getLogger(LogInDebtorController.class);

    private RestTemplate restTemplate;

    @Value("${api_url}")
    private String API_URL;

    private final String API_URL_LOGIN="login/";

    @Autowired
    public LogInDebtorController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getAPI_URL() {
        return API_URL;
    }

    AuthorisationEffect confirmThatDebtorExists(Debtor debtor) {
        try {
            ResponseEntity response = restTemplate.postForEntity((API_URL + API_URL_LOGIN), debtor, Debtor.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                LOG.info("Login successful :" + debtor.getFirstName() + " " + debtor.getLastName());
                return AuthorisationEffect.RECOGNISED;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                LOG.warn("Debtor not found: " + debtor.toString());
                return AuthorisationEffect.NOT_RECOGNISED;
            } else {
                LOG.error("Error, http status code: " + e.getStatusCode().toString());
            }
        } catch (Exception e) {
            LOG.error("Error connecting to server: " + e.getMessage());
        }
        return AuthorisationEffect.ERROR;
    }
}
