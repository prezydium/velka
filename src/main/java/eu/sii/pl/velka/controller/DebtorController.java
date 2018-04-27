package eu.sii.pl.velka.controller;

import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.VelkaUI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class DebtorController {

    private final Logger LOG = Logger.getLogger("Communication logger");

    private Debtor debtor;

    public DebtorController(Debtor debtor) {
        this.debtor = debtor;
    }

    public void confirmThatDebtorExists() {
        RestTemplate restTemplate = new RestTemplate();
        String testResourceUrl = "http://localhost:8090/login"; //testURL
        try {
            ResponseEntity response = restTemplate.postForEntity(testResourceUrl, debtor, Debtor.class);
            UI.getCurrent().getNavigator().navigateTo(VelkaUI.SUCCESSFULOGINVIEW);
        } catch (HttpClientErrorException e) {
            LOG.log(Level.WARNING, e.getStatusCode().toString());
            UI.getCurrent().getNavigator().navigateTo(VelkaUI.FAILEDOGINVIEW);
        }
    }
}
