package eu.sii.pl.velka.UI.views;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import eu.sii.pl.velka.UI.viewModel.PaymentFormView;
import eu.sii.pl.velka.UI.views.components.PaymentLayout;
import eu.sii.pl.velka.controller.CommunicationController;
import eu.sii.pl.velka.model.PaymentForm;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name="payment")
public class PaymentView  extends VerticalLayout implements View {

    @Autowired
    private CommunicationController communicateWithAPI;

    private PaymentLayout formLayout = new PaymentLayout(this::clickSubmitButton);

    public PaymentView(){
        this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.addComponent(formLayout);
        PaymentFormView paymentFormView = new PaymentFormView();
        formLayout.setModel(paymentFormView);
    }


    private void clickSubmitButton(Button.ClickEvent clickEvent) {
        PaymentFormView localPayment = (PaymentFormView) formLayout.getModel();
        PaymentForm paymentForm=localPayment.maptoPaymentForm();
        communicateWithAPI.sentPaymentToAPI(paymentForm);
    }
}
