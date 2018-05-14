package eu.sii.pl.velka.controller;

import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import eu.sii.pl.velka.converters.SsnConverter;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.UI.authorisation.ErrorLoginView;
import eu.sii.pl.velka.UI.authorisation.SuccessfulLoginView;
import eu.sii.pl.velka.UI.authorisation.UnrecognisedUserLoginView;
import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
@UIScope
public class CommunicationWIthMiCuentaAPIController {

    @Autowired
    private SpringNavigator springNavigator;

    @Autowired
    private LogInDebtorController logInDebtorController;

    @Autowired
    private PaymentController paymentController;

    @Autowired
    private BalanceController balanceController;

    private Map<AuthorisationEffect, String> authorizationNavigationRout = new HashMap<AuthorisationEffect, String>() {{
        put(AuthorisationEffect.RECOGNISED, SuccessfulLoginView.VIEW_NAME);
        put(AuthorisationEffect.NOT_RECOGNISED, UnrecognisedUserLoginView.VIEW_NAME);
    }};

    public void communicateWithAPI(Debtor debtor) {
        debtor.setSsn(new SsnConverter().convertSsnToFormatAcceptableByAPI(debtor.getSsn()));
        AuthorisationEffect authorisationEffect = logInDebtorController.confirmThatDebtorExists(debtor);
        switchViewAfterApiResponse(authorisationEffect);
        if (authorisationEffect == AuthorisationEffect.RECOGNISED) {
            debtor = balanceController.getFullData(debtor.getSsn());
            VaadinSession.getCurrent().setAttribute("debtor", debtor);
            springNavigator.navigateTo("balance");
        }
    }

    public void sentPaymentDeclarationToAPI(PaymentDeclaration paymentDeclaration) {
            PaymentPlan paymentPlan=paymentController.getPaymentPlan(paymentDeclaration);
            VaadinSession.getCurrent().setAttribute("paymentPlan", paymentPlan);
            springNavigator.navigateTo("paymentPlan");
    }

    private void switchViewAfterApiResponse(AuthorisationEffect authorisationEffect) {
        String navigationTarget = authorizationNavigationRout.getOrDefault(authorisationEffect, ErrorLoginView.VIEW_NAME);
        springNavigator.navigateTo(navigationTarget);
    }
}
