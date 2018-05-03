package eu.sii.pl.velka.controller;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.authorisation.ErrorLoginView;
import eu.sii.pl.velka.view.authorisation.SuccessfulLoginView;
import eu.sii.pl.velka.view.authorisation.UnrecognisedUserLoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@UIScope
public class CommunicationController {

    @Autowired
    private SpringNavigator springNavigator;

    @Autowired
    private LogInDebtorController logInDebtorController;

    @Autowired
    private GetFullDataDebtorController getFullDataDebtorController;

    public void communicateWithAPI(Debtor debtor) {
        AuthorisationEffect authorisationEffect = logInDebtorController.confirmThatDebtorExists(debtor);
        switchViewAfterApiResponse(authorisationEffect);
        debtor = getFullDataDebtorController.getFullData(debtor.getSsn());
    }

    private void switchViewAfterApiResponse(AuthorisationEffect authorisationEffect) {
        switch (authorisationEffect) {
            case NOT_RECOGNISED:
                springNavigator.navigateTo(UnrecognisedUserLoginView.VIEW_NAME);
                break;
            case RECOGNISED:
                springNavigator.navigateTo(SuccessfulLoginView.VIEW_NAME);
                break;
            default:
                springNavigator.navigateTo(ErrorLoginView.VIEW_NAME);
        }
    }
}
