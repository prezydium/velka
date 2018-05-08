package eu.sii.pl.velka.view;

import com.vaadin.annotations.PropertyId;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button;

public class PaymentForm extends AbstractDataForm<PaymentForm> {

    private Label formHeader = new Label("Enter your details to pay your debts");

    @PropertyId("payment")
    private TextField textFieldName = new TextField("Payment: ");

    @PropertyId("debtUuid")
    private TextField textFieldSurname = new TextField("debtUuid: ");

    @PropertyId("ssn")
    private TextField textFieldSsn = new TextField("SSN: ");

    public PaymentForm() {
        super();
//        binder.bindInstanceFields(this);
//        styleUI();
//        Button confirmButton = new Button("Submit", clickListener);
        addComponents( formHeader, textFieldName,textFieldSsn,textFieldSurname);
    }

    private void styleUI() {
        textFieldName.setWidth("50%");
        textFieldSurname.setWidth("50%");
        textFieldSsn.setWidth("50%");
        formHeader.addStyleName(ValoTheme.TEXTFIELD_HUGE);
        setSpacing(true);
        setWidth("80%");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    }

    @Override
    protected Class<PaymentForm> getModelClass() {
        return PaymentForm.class;
    }
}