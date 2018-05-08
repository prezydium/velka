package eu.sii.pl.velka.UI.views.components;

import com.vaadin.annotations.PropertyId;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.UI.viewModel.PaymentFormView;
import eu.sii.pl.velka.UI.views.AbstractDataForm;

public class PaymentLayout extends AbstractDataForm<PaymentFormView> {

    private Label formHeader = new Label("Enter your details to pay your debts");

    @PropertyId("debtUuid")
    private TextField textFieldDebtId = new TextField("debtUuid: ");

    @PropertyId("snn")
    private TextField textFieldSsn = new TextField("SSN: ");

//    @PropertyId("paymentAmount")
//    private TextField textFieldAmount = new TextField("Amount: ");

    private Label creditCartHeader = new Label("Credit Card data:");

    @PropertyId("ccNumber")
    private TextField textFieldccNumber = new TextField("CcNumber: ");

    @PropertyId("issuingNetwork")
    private TextField textFieldissuingNetwork = new TextField("Issuing Network: ");

//    @PropertyId("expDate")
//    private TextField textFieldExpDate = new TextField("Expire Date: ");

    @PropertyId("cvv")
    private TextField textFieldCvv = new TextField("Cvv: ");

    @PropertyId("firstName")
    private TextField textFieldFirstName = new TextField("First Name: ");

    @PropertyId("lastName")
    private TextField textFieldLastName = new TextField("Last Name: ");


    public PaymentLayout(Button.ClickListener clickListener) {
        super();
        binder.bindInstanceFields(this);
        styleUI();
        Button payButton = new Button("Pay", clickListener);
        addComponents(formHeader, textFieldDebtId, textFieldSsn,
               // textFieldAmount,
                creditCartHeader, textFieldFirstName,
                textFieldLastName, textFieldccNumber,textFieldissuingNetwork, textFieldCvv, payButton);
    }

    private void styleUI() {
        formHeader.addStyleName(ValoTheme.TEXTFIELD_HUGE);
        setSpacing(true);
        setWidth("80%");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    }

    @Override
    protected Class<PaymentFormView> getModelClass() {
        return PaymentFormView.class;
    }
}