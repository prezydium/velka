package eu.sii.pl.velka.view;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import eu.sii.pl.velka.model.Debtor;

public class PaymentMethodWindow extends Window {

    private CreditCardForm creditCardForm;

    private Button creditCardButton = new Button("Pay by credit card", this::creditCardClick);

    private Button anotherMethod = new Button(" Pay by another method", this::anotherMethodClick);

    private VerticalLayout windowLayout = new VerticalLayout();

    private HorizontalLayout buttonLayout =  new HorizontalLayout();

    private VerticalLayout paymentMethodForm = new VerticalLayout();

    public PaymentMethodWindow() {
        paymentMethodForm.setVisible(false);
        setCaption("Choose payment method: ");
        buttonLayout.addComponents(creditCardButton, anotherMethod);
        windowLayout.addComponents(buttonLayout, paymentMethodForm);
        setContent(windowLayout);
        setClosable(false);
        center();
        setModal(true);
        setResizable(false);
    }


    private void creditCardClick(Button.ClickEvent clickEvent) {
        paymentMethodForm.removeAllComponents();
        paymentMethodForm.setVisible(true);
        paymentMethodForm.addComponent(new CreditCardForm(((Debtor)VaadinSession.getCurrent().getAttribute("debtor"))));
        this.center();
    }
    private void anotherMethodClick(Button.ClickEvent clickEvent) {
        paymentMethodForm.removeAllComponents();
        paymentMethodForm.setVisible(true);
        paymentMethodForm.addComponent(new Button("Sell kidney", clickEvent1 -> {
            Notification.show("You sold kidney", "Doctors will be arriving shortly, stay where you are!", Notification.Type.ERROR_MESSAGE);
        }));
        this.center();
    }
}
