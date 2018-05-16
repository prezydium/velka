package eu.sii.pl.velka.ui.windows.payment;

import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import eu.sii.pl.velka.model.Debtor;

import java.util.HashMap;
import java.util.Map;

public class PaymentMethodWindow extends Window {

    private CreditCardForm creditCardForm;

    private Button creditCardButton = new Button("Pay by credit card", this::buttonClick);

    private Button bitcoinButton = new Button(" Pay by Bitcoin", this::buttonClick);

    private VerticalLayout windowLayout = new VerticalLayout();

    private HorizontalLayout buttonLayout =  new HorizontalLayout();

    private VerticalLayout paymentMethodForm = new VerticalLayout();

    private Map<String, Component> paymentMethods = new HashMap<String, Component>(){{
        put("1", new CreditCardForm((Debtor)VaadinSession.getCurrent().getAttribute("debtor")));
        put("2", new VerticalLayout((new Label("Will be implemented shortly"))));
    }};

    public PaymentMethodWindow() {
        this.setUpButtons();
        paymentMethodForm.setVisible(false);
        setCaption("Choose payment method: ");
        windowLayout.addComponents(buttonLayout, paymentMethodForm);
        setContent(windowLayout);
        setModal(true);
        setResizable(false);
        center();
    }

    private void setUpButtons(){
        creditCardButton.setId("1");
        bitcoinButton.setId("2");
        buttonLayout.addComponents(creditCardButton, bitcoinButton);
    }

    private void buttonClick(Button.ClickEvent clickEvent) {
        paymentMethodForm.removeAllComponents();
        paymentMethodForm.setVisible(true);
        paymentMethodForm.addComponent(paymentMethods.get(clickEvent.getButton().getId()));
        center();
    }
}
