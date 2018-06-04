package eu.sii.pl.velka.service;

import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import eu.sii.pl.velka.converters.SsnConverter;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.ui.authorisation.ErrorLoginView;
import eu.sii.pl.velka.ui.authorisation.SuccessfulLoginView;
import eu.sii.pl.velka.ui.authorisation.UnrecognisedUserLoginView;
import eu.sii.pl.velka.ui.views.WaitingView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@UIScope
public class APIServiceCommunication {

    @Autowired
    private SpringNavigator springNavigator;

    @Autowired
    private LogInDebtorService logInDebtorService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BalanceService balanceService;

    private Map<AuthorisationEffect, String> authorizationNavigationRout = new HashMap<AuthorisationEffect, String>() {{
        put(AuthorisationEffect.RECOGNISED, SuccessfulLoginView.VIEW_NAME);
        put(AuthorisationEffect.NOT_RECOGNISED, UnrecognisedUserLoginView.VIEW_NAME);
        put(AuthorisationEffect.WAITING, WaitingView.VIEW_NAME);
    }};

    public void sentDebtorToAPI(Debtor debtor) {
        debtor.setSsn(new SsnConverter().convertSsnToFormatAcceptableByAPI(debtor.getSsn()));
        AuthorisationEffect authorisationEffect = logInDebtorService.confirmThatDebtorExists(debtor);
        VaadinSession.getCurrent().setAttribute("debtor", debtor);
        switchViewAfterApiResponse(authorisationEffect);
        if (authorisationEffect == AuthorisationEffect.RECOGNISED) {
            debtor = balanceService.getFullData(debtor.getSsn());
            VaadinSession.getCurrent().setAttribute("debtor", debtor);
            springNavigator.navigateTo("balance");
        }
    }

    public void sentPaymentDeclarationToAPI(PaymentDeclaration paymentDeclaration) {
        AuthorisationEffect authorisationEffect = paymentService.trySendPayment(paymentDeclaration);
        PaymentPlan paymentPlan = paymentService.getPaymentPlan(paymentDeclaration);
        switchViewAfterApiResponse(authorisationEffect);
        if (authorisationEffect == AuthorisationEffect.RECOGNISED) {

            VaadinSession.getCurrent().setAttribute("paymentPlan", paymentPlan);
            springNavigator.navigateTo("paymentPlan");
        } else if (authorisationEffect == AuthorisationEffect.WAITING) {

        } else {
            springNavigator.navigateTo("errorPayment");
        }
    }

    private void switchViewAfterApiResponse(AuthorisationEffect authorisationEffect) {
        String navigationTarget = authorizationNavigationRout.getOrDefault(authorisationEffect, ErrorLoginView.VIEW_NAME);
        springNavigator.navigateTo(navigationTarget);
    }
}
