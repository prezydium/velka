package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.Debtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Profile("!jms")
public class BalanceServiceRest implements BalanceService {

    private final static Logger LOG = LoggerFactory.getLogger(BalanceServiceRest.class);

    private RestTemplate restTemplate;

    @Value("${api_url}")
    private String API_URL;

    private String API_URL_GET_DEBTOR="balance/";

    @Autowired
    public BalanceServiceRest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

  @Override
    public Debtor getFullData(String ssn) {
        String urlWithGet = API_URL + API_URL_GET_DEBTOR + ssn;
        Debtor localDebtor = new Debtor();
        try {
            localDebtor = restTemplate.getForObject(urlWithGet, Debtor.class);
            LOG.info("Getting debtor from api");
        } catch (Exception e) {
            LOG.error("Error getting debtor data" + e.getMessage());
        }
        return localDebtor;
    }
}
