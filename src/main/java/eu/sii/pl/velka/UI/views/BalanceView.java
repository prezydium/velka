package eu.sii.pl.velka.UI.views;

import com.vaadin.data.BinderValidationStatus;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.sii.pl.velka.UI.viewModel.PaymentDeclarationView;
import eu.sii.pl.velka.UI.views.components.HeaderLayout;
import eu.sii.pl.velka.UI.views.components.PaymentLayout;
import eu.sii.pl.velka.UI.views.components.TableLayout;
import eu.sii.pl.velka.controller.CommunicationWIthMiCuentaAPIController;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentDeclaration;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = "balance")
public class BalanceView extends VerticalLayout implements View {


    private PaymentLayout formLayout = new PaymentLayout(this::clickSubmitButton);

    @Autowired
    private CommunicationWIthMiCuentaAPIController communicateWithAPI;


    public BalanceView() {
        Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
        this.addComponent(new HeaderLayout(debtor));
        this.addComponent(new TableLayout(debtor));
        this.addComponent(this.formLayout);
        PaymentDeclarationView paymentDeclarationView = new PaymentDeclarationView();
        formLayout.setModel(paymentDeclarationView);
    }

    private void clickSubmitButton(Button.ClickEvent clickEvent) {

        BinderValidationStatus<PaymentDeclarationView> status = formLayout.getBinder().validate();

        if (status.hasErrors()) {
            Notification.show("Validation error: "
                    + status.getValidationErrors().get(0).getErrorMessage());
        } else {
            PaymentDeclarationView paymentDeclarationView = (PaymentDeclarationView) formLayout.getModel();
            PaymentDeclaration paymentDeclaration = paymentDeclarationView.mapToPaymentDeclaration();
            communicateWithAPI.sentPaymentDeclarationToAPI(paymentDeclaration);
        }
    }
}
