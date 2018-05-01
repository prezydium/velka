package eu.sii.pl.velka.controller;

import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.VelkaUI;
import eu.sii.pl.velka.view.authorisationeffect.ErrorLoginView;
import eu.sii.pl.velka.view.authorisationeffect.SuccessfulLoginView;
import eu.sii.pl.velka.view.authorisationeffect.UnrecognisedUserLoginView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringComponent
@ViewScope
public class DebtorController {

    private final Logger LOG = Logger.getLogger("Communication logger");

    @Value("${api_url}")
    private String API_URL;

    @RequestMapping
    public void confirmThatDebtorExists(Debtor debtor) {
        RestTemplate restTemplate = new RestTemplate();
        String testResourceUrl = API_URL;
        debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
                //"http://localhost:8090/login"; //testURL, will be removed TODO
        try {
            ResponseEntity response = restTemplate.postForEntity(testResourceUrl, debtor, Debtor.class);
            VaadinSession.getCurrent().setAttribute("isRecognisedUser", Boolean.TRUE);
            UI.getCurrent().getNavigator().navigateTo(SuccessfulLoginView.VIEW_NAME);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                UI.getCurrent().getNavigator().navigateTo(UnrecognisedUserLoginView.VIEW_NAME);
            } else {
                LOG.log(Level.WARNING, "Error, http status code: " + e.getStatusCode().toString() );
                UI.getCurrent().getNavigator().navigateTo(ErrorLoginView.VIEW_NAME);
            }
        } catch (ResourceAccessException e){
            LOG.log(Level.SEVERE, "Error connecting to server");
            UI.getCurrent().getNavigator().navigateTo(ErrorLoginView.VIEW_NAME);
        }
    }
}
