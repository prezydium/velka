package eu.sii.pl.velka.controller;

import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.UI.authorisation.ErrorLoginView;
import eu.sii.pl.velka.UI.authorisation.SuccessfulLoginView;
import eu.sii.pl.velka.UI.authorisation.UnrecognisedUserLoginView;
import eu.sii.pl.velka.model.PaymentForm;
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
    private BalanceController balanceController;

    public void communicateWithAPI(Debtor debtor) {
        AuthorisationEffect authorisationEffect = logInDebtorController.confirmThatDebtorExists(debtor);
        switchViewAfterApiResponse(authorisationEffect);
        if (authorisationEffect == AuthorisationEffect.RECOGNISED) {
            debtor = balanceController.getFullData(debtor.getSsn());
            VaadinSession.getCurrent().setAttribute("debtor", debtor);
            springNavigator.navigateTo("balance");
        }
    }public void sentPaymentToAPI(PaymentForm paymentForm) {
        AuthorisationEffect authorisationEffect = logInDebtorController.confirmPayment(paymentForm);
        switchViewAfterApiResponse(authorisationEffect);
        if (authorisationEffect == AuthorisationEffect.RECOGNISED) {
            Debtor debtor = balanceController.getFullData(paymentForm.getSnn());
            VaadinSession.getCurrent().setAttribute("debtor", debtor);
            springNavigator.navigateTo("balance");
        }
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
