package eu.sii.pl.velka.UI.views.components;

import com.vaadin.annotations.PropertyId;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.UI.viewModel.PaymentDeclarationView;
import eu.sii.pl.velka.UI.views.AbstractDataForm;
import eu.sii.pl.velka.validation.AmountValidator;
import eu.sii.pl.velka.validation.SsnValidator;
import eu.sii.pl.velka.validation.UuidValidator;


public class PaymentLayout extends AbstractDataForm<PaymentDeclarationView> {

    private Label formHeader = new Label("Enter your details to pay your debts");

    @PropertyId("debtUuid")
    private TextField textFieldDebtId = new TextField("debtUuid: ");

    @PropertyId("amount")
    private TextField textFieldAmount = new TextField("Amount: ");


    public PaymentLayout(Button.ClickListener clickListener) {
        super();
        setUpValidation();
        binder.bindInstanceFields(this);
        styleUI();
        Button payButton = new Button("Submit", clickListener);
        addComponents(formHeader, textFieldDebtId,
                //textFieldSsn,
                textFieldAmount,
                payButton);
    }

    private void styleUI() {
        formHeader.addStyleName(ValoTheme.TEXTFIELD_HUGE);
        setSpacing(true);
        setWidth("80%");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    }

    private void setUpValidation() {
        textFieldAmount.setValueChangeMode(ValueChangeMode.BLUR);
        binder.forMemberField(textFieldAmount)
                .withValidator(new AmountValidator())
                .asRequired();
        textFieldAmount.setValueChangeMode(ValueChangeMode.BLUR);
        binder.forMemberField(textFieldDebtId)
                .withValidator(new UuidValidator());
    }

    @Override
    protected Class<PaymentDeclarationView> getModelClass() {
        return PaymentDeclarationView.class;
    }
}