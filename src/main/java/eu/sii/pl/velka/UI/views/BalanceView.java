package eu.sii.pl.velka.UI.views;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.sii.pl.velka.UI.viewModel.PaymentFormView;
import eu.sii.pl.velka.UI.views.components.HeaderLayout;
import eu.sii.pl.velka.UI.views.components.PaymentLayout;
import eu.sii.pl.velka.UI.views.components.TableLayout;
import eu.sii.pl.velka.controller.CommunicationController;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentDeclaration;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = "balance")
public class BalanceView extends VerticalLayout implements View {


    private PaymentLayout formLayout = new PaymentLayout(this::clickSubmitButton);

    @Autowired
    private CommunicationController communicateWithAPI;


    public BalanceView() {
        Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
        this.addComponent(new HeaderLayout(debtor));
        this.addComponent(new TableLayout(debtor));
        this.addComponent(this.formLayout);
        PaymentFormView paymentFormView=new PaymentFormView();
        formLayout.setModel(paymentFormView);
    }

    private void clickSubmitButton(Button.ClickEvent clickEvent) {
        PaymentFormView localPayment = (PaymentFormView) formLayout.getModel();
        PaymentDeclaration paymentDeclaration = localPayment.maptoPaymentDeclaration();
        communicateWithAPI.sentPaymentToAPI(paymentDeclaration);
    }
}
