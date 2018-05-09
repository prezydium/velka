package eu.sii.pl.velka.UI.views.components;

import com.vaadin.annotations.PropertyId;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.UI.viewModel.PaymentFormView;
import eu.sii.pl.velka.UI.views.AbstractDataForm;
import eu.sii.pl.velka.validation.AmountValidator;
import eu.sii.pl.velka.validation.SsnValidator;
import eu.sii.pl.velka.validation.UuidValidator;


public class PaymentLayout extends AbstractDataForm<PaymentFormView> {

    private Label formHeader = new Label("Enter your details to pay your debts");

    @PropertyId("debtUuid")
    private TextField textFieldDebtId = new TextField("debtUuid: ");

    @PropertyId("ssn")
    private TextField textFieldSsn = new TextField("SSN: ");

    @PropertyId("paymentAmount")
    private TextField textFieldAmount = new TextField("Amount: ");


    public PaymentLayout(Button.ClickListener clickListener) {
        super();
        setUpValidation();
        PaymentFormView paymentFormView = this.getModel();
        binder.bindInstanceFields(this);
        styleUI();
        Button payButton = new Button("Pay", clickListener);
        addComponents(formHeader, textFieldDebtId, textFieldSsn,
                textFieldAmount, payButton);
    }

    private void styleUI() {
        formHeader.addStyleName(ValoTheme.TEXTFIELD_HUGE);
        setSpacing(true);
        setWidth("80%");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    }

    private void setUpValidation() {
        textFieldSsn.setValueChangeMode(ValueChangeMode.BLUR);
        binder.forMemberField(textFieldSsn)
                .withValidator(new SsnValidator())
                .asRequired();
        textFieldAmount.setValueChangeMode(ValueChangeMode.BLUR);
        binder.forMemberField(textFieldAmount)
                .withValidator(new AmountValidator())
                .asRequired();
        textFieldAmount.setValueChangeMode(ValueChangeMode.BLUR);
        binder.forMemberField(textFieldDebtId)
                .withValidator(new UuidValidator());
    }

    @Override
    protected Class<PaymentFormView> getModelClass() {
        return PaymentFormView.class;
    }
}