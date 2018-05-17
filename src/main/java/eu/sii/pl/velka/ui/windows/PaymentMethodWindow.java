package eu.sii.pl.velka.ui.windows;

import com.vaadin.data.BinderValidationStatus;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentConfirmation;
import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.ui.views.AbstractDataForm;
import eu.sii.pl.velka.ui.views.SuccessfulPaymentView;
import eu.sii.pl.velka.ui.windows.forms.BitCoinForm;
import eu.sii.pl.velka.ui.windows.forms.CreditCardForm;
import eu.sii.pl.velka.ui.windows.forms.NotChosenForm;

import java.util.HashMap;
import java.util.Map;

public class PaymentMethodWindow extends Window {

    private Button creditCardButton = new Button("Pay by credit card", this::buttonClick);

    private Button bitcoinButton = new Button(" Pay by Bitcoin", this::buttonClick);

    private VerticalLayout windowLayout = new VerticalLayout();

    private HorizontalLayout buttonLayout = new HorizontalLayout();

    private AbstractDataForm paymentMethodForm;

    private Button buttonSubmit = new Button("Submit", this::submitButtonClick);

    private Map<String, AbstractDataForm> paymentMethods = new HashMap<String, AbstractDataForm>() {{
        put(NotChosenForm.PAYMENT_METHOD_NAME, new NotChosenForm());
        put(CreditCardForm.PAYMENT_METHOD_NAME, new CreditCardForm((Debtor) VaadinSession.getCurrent().getAttribute("debtor")));
        put(BitCoinForm.PAYMENT_METHOD_NAME, new BitCoinForm());
    }};

    public PaymentMethodWindow() {
        this.setUpButtons();
        paymentMethodForm = paymentMethods.get(NotChosenForm.PAYMENT_METHOD_NAME);
        paymentMethodForm.setVisible(false);
        setCaption("Choose payment method: ");
        windowLayout.addComponents(buttonLayout, paymentMethodForm, buttonSubmit);
        setContent(windowLayout);
        setModal(true);
        setResizable(false);
        center();
    }

    private void setUpButtons() {
        creditCardButton.setId(CreditCardForm.PAYMENT_METHOD_NAME);
        bitcoinButton.setId(BitCoinForm.PAYMENT_METHOD_NAME);
        buttonLayout.addComponents(creditCardButton, bitcoinButton);
    }

    private void buttonClick(Button.ClickEvent clickEvent) {
        paymentMethodForm.removeAllComponents();
        paymentMethodForm.setVisible(true);
        paymentMethodForm.addComponent(paymentMethods.get(clickEvent.getButton().getId()));
        center();
    }

    private void submitButtonClick(Button.ClickEvent clickEvent) {
        BinderValidationStatus<Object> status = paymentMethodForm.getBinder().validate();
        if (status.hasErrors()) {
            Notification.show("Validation error: "
                    + status.getValidationErrors().get(0).getErrorMessage());
        } else {
            /*
            * this part only support credit card method according to model at 17.05.2018
            * */
            CreditCard localCreditCard = (CreditCard) paymentMethodForm.getModel();
            PaymentConfirmation paymentConfirmation = new PaymentConfirmation((PaymentDeclaration) VaadinSession
                    .getCurrent().getAttribute("paymentDeclaration"), localCreditCard);
            VaadinSession.getCurrent().setAttribute("paymentConfirmation", paymentConfirmation);
            UI.getCurrent().getNavigator().navigateTo(SuccessfulPaymentView.VIEW_NAME);
            this.close();
        }
    }
}
