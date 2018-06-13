package eu.sii.pl.velka.ui.views;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentConfirmation;
import eu.sii.pl.velka.service.BalanceService;
import eu.sii.pl.velka.service.PaymentConfirmationService;

import static com.vaadin.server.VaadinSession.getCurrent;

@SpringView(name = SuccessfulPaymentView.VIEW_NAME)
public class SuccessfulPaymentView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "successfulpayment";

    private BalanceService balanceService;

    private SpringNavigator springNavigator;

    private PaymentConfirmationService paymentConfirmationService;

    public SuccessfulPaymentView(BalanceService balanceService, SpringNavigator springNavigator, PaymentConfirmationService paymentConfirmationService) {
        this.balanceService = balanceService;
        this.springNavigator = springNavigator;
        this.paymentConfirmationService = paymentConfirmationService;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        paymentConfirmationService.sendPaymentConfirmation((PaymentConfirmation) getCurrent().getAttribute("paymentConfirmation"));
        VaadinSession.getCurrent().setAttribute("debtor", balanceService.getFullData(((Debtor) getCurrent().getAttribute("debtor")).getSsn()).get());
        Notification.show("YOUR PAYMENT WAS REGISTERED SUCCESSFULLY");
        springNavigator.navigateTo(BalanceView.VIEW_NAME);
    }
}
