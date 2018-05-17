package eu.sii.pl.velka.ui.views;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import eu.sii.pl.velka.controller.BalanceController;
import eu.sii.pl.velka.controller.PaymentConfirmationController;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentConfirmation;

import static com.vaadin.server.VaadinSession.getCurrent;

@SpringView(name = SuccessfulPaymentView.VIEW_NAME)
public class SuccessfulPaymentView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "successfulpayment";

    private BalanceController balanceController;

    private SpringNavigator springNavigator;

    private PaymentConfirmationController paymentConfirmationController;

    public SuccessfulPaymentView(BalanceController balanceController, SpringNavigator springNavigator, PaymentConfirmationController paymentConfirmationController) {
        this.balanceController = balanceController;
        this.springNavigator = springNavigator;
        this.paymentConfirmationController = paymentConfirmationController;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        paymentConfirmationController.sendPaymentConfirmation((PaymentConfirmation) getCurrent().getAttribute("paymentConfirmation"));
        VaadinSession.getCurrent().setAttribute("debtor", balanceController.getFullData(((Debtor) getCurrent().getAttribute("debtor")).getSsn()));
        Notification.show("YOUR PAYMENT WAS REGISTERED SUCCESSFULLY");
        springNavigator.navigateTo(BalanceView.VIEW_NAME);
    }
}
