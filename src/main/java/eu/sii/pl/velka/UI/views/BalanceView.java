package eu.sii.pl.velka.UI.views;

import com.vaadin.data.BinderValidationStatus;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import eu.sii.pl.velka.UI.viewModel.PaymentDeclarationView;
import eu.sii.pl.velka.UI.views.components.HeaderLayout;
import eu.sii.pl.velka.UI.views.components.PaymentLayout;
import eu.sii.pl.velka.UI.views.components.TableLayout;
import eu.sii.pl.velka.controller.CommunicationWIthMiCuentaAPIController;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentDeclaration;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = BalanceView.VIEW_NAME)
public class BalanceView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "balance";

    private PaymentLayout paymentLayout = new PaymentLayout(this::clickSubmitButton);

    @Autowired
    private CommunicationWIthMiCuentaAPIController communicateWithAPI;

    private Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");

    public BalanceView() {
        this.addComponent(new HeaderLayout(debtor));
        this.addComponent(new TableLayout(debtor));
        this.addComponent(this.paymentLayout);
        PaymentDeclarationView paymentDeclarationView = new PaymentDeclarationView();
        paymentLayout.setModel(paymentDeclarationView);
    }

    private void clickSubmitButton(Button.ClickEvent clickEvent) {
        BinderValidationStatus<PaymentDeclarationView> status = paymentLayout.getBinder().validate();

        if (status.hasErrors()) {
            Notification.show("Validation error: "
                    + status.getValidationErrors().get(0).getErrorMessage());
        } else {
            PaymentDeclarationView paymentDeclarationView = (PaymentDeclarationView) paymentLayout.getModel();
            paymentDeclarationView.setSsn(debtor.getSsn());
            PaymentDeclaration paymentDeclaration = paymentDeclarationView.mapToPaymentDeclaration();
            communicateWithAPI.sentPaymentDeclarationToAPI(paymentDeclaration);
        }
    }
}
