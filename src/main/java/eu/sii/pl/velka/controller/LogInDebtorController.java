package eu.sii.pl.velka.controller;

import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.authorisation.ErrorLoginView;
import eu.sii.pl.velka.view.authorisation.SuccessfulLoginView;
import eu.sii.pl.velka.view.authorisation.UnrecognisedUserLoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringComponent
@RequestScope
public class LogInDebtorController {

    private final Logger LOG = Logger.getLogger(LogInDebtorController.class.getName());

    private RestTemplate restTemplate;

    @Value("${api_url}")
    private String API_URL;

    public LogInDebtorController() {
        restTemplate = new RestTemplate();
    }

    @RequestMapping
    public void confirmThatDebtorExists(Debtor debtor) {
        String navigationTarget = "";
        try {
            ResponseEntity response = restTemplate.postForEntity(API_URL, debtor, Debtor.class);
            if (response.getStatusCode()== HttpStatus.OK){
                navigationTarget = SuccessfulLoginView.VIEW_NAME;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                navigationTarget = UnrecognisedUserLoginView.VIEW_NAME;
            } else {
                LOG.log(Level.WARNING, "Error, http status code: " + e.getStatusCode().toString());
                navigationTarget = ErrorLoginView.VIEW_NAME;
            }
        } catch (ResourceAccessException e) {
            LOG.log(Level.SEVERE, "Error connecting to server");
            navigationTarget = ErrorLoginView.VIEW_NAME;
        } finally {
          switchViewAfterApiResponse(navigationTarget);
        }
    }
    protected void switchViewAfterApiResponse(String s) {
        UI.getCurrent().getNavigator().navigateTo(s);
    }
}
