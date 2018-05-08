package eu.sii.pl.velka.UI.views;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.sii.pl.velka.UI.viewModel.PaymentFormView;
import eu.sii.pl.velka.UI.views.components.HeaderLayout;
import eu.sii.pl.velka.UI.views.components.PaymentLayout;
import eu.sii.pl.velka.UI.views.components.TableLayout;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentForm;

@SpringView(name = "balance")
public class BalanceView extends VerticalLayout implements View {

    ;
    //private PaymentLayout paymentLayout = new PaymentLayout(this::clickSubmitButton);


    public BalanceView() {
        Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
        ;
        this.addComponent(new HeaderLayout(debtor));
        this.addComponent(new TableLayout(debtor));
       // this.addComponent(this.paymentLayout);
    }


//    private void clickSubmitButton(Button.ClickEvent clickEvent) {
//        PaymentFormView paymentFormView = (PaymentFormView) paymentLayout.getModel();
//        PaymentForm paymentForm = paymentFormView.maptoPaymentForm();
//
//
//        // communicateWithAPI.communicateWithAPI(localDebtor);
//    }
}
