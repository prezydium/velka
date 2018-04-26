package eu.sii.pl.velka.controller;

import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.SuccessfulLoginView;
import eu.sii.pl.velka.view.VelkaUI;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommunicationWithApi {

    private final Logger LOG = Logger.getLogger("Communication logger");

    private DebtorController debtorController = new DebtorController();

    private Debtor debtor;

    public void processLogIn(Debtor debtor) {
        this.debtor = debtor;
        HttpStatus responseCode = debtorController.confirmThatDebtorExists(debtor);
        switchViewAccordingToResponseStatusCode(responseCode);

    }


    void switchViewAccordingToResponseStatusCode(HttpStatus responseCode) {

        if (responseCode == HttpStatus.OK) {
            UI.getCurrent().getNavigator().navigateTo(VelkaUI.SUCCESSFULOGINVIEW);
        } else if (responseCode == HttpStatus.NOT_FOUND) {
            LOG.log(Level.WARNING, "tried to login: " + debtor.toString());
            UI.getCurrent().getNavigator().navigateTo(VelkaUI.STARTVIEW);
        } else if (responseCode == HttpStatus.INTERNAL_SERVER_ERROR) {
            LOG.log(Level.SEVERE, "Server error");
        } else {
            LOG.log(Level.SEVERE, "Http error: " + HttpStatus.values());
        }

    }


}
