package eu.sii.pl.velka.controller;

import com.vaadin.server.Page;
import com.vaadin.shared.ui.Connect;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.authorisation.ErrorLoginView;
import eu.sii.pl.velka.view.authorisation.SuccessfulLoginView;
import eu.sii.pl.velka.view.authorisation.UnrecognisedUserLoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

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
    public LogInDebtorController(RestTemplateBuilder restTemplateBuilder ) {
        this.getFullDataDebtorController = getFullDataDebtorController;
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping
    public void confirmThatDebtorExists(Debtor debtor) {
        try {
            ResponseEntity response = restTemplate.postForEntity(API_URL, debtor, Debtor.class);
            if (response.getStatusCode()== HttpStatus.OK){
                navigationTarget = SuccessfulLoginView.VIEW_NAME;
//                System.out.println(getFullDataDebtorController.getFullData(debtor.getSsn()));
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                navigationTarget = UnrecognisedUserLoginView.VIEW_NAME;
            } else {
                LOG.log(Level.WARNING, "Error, http status code: " + e.getStatusCode().toString());
                navigationTarget = ErrorLoginView.VIEW_NAME;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error connecting to server");
            navigationTarget = ErrorLoginView.VIEW_NAME;
        } finally {
          switchViewAfterApiResponse(navigationTarget);
        }
    }
    private void switchViewAfterApiResponse(String s) {
      //  UI.getCurrent().getNavigator().navigateTo(s);
    }

    public String getAPI_URL() {
        return API_URL;
    }

    public String getNavigationTarget() {
        return navigationTarget;
    }
}
