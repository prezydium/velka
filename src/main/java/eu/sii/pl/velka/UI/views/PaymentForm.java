package eu.sii.pl.velka.UI.views;

import com.vaadin.ui.*;

public class PaymentForm extends VerticalLayout {

    public PaymentForm() {
        Label formHeader = new Label("Enter your details to pay your debts");
        TextField textFieldDebtId = new TextField("debtUuid: ");
        TextField textFieldSsn = new TextField("SSN: ");
        TextField textFieldAmount = new TextField("Amount: ");
        Label creditCartHeader = new Label("Credit Card data:");
        TextField textFieldccNumber = new TextField("CcNumber: ");
        TextField textFieldExpDate = new TextField("Expire Date: ");
        TextField textFieldCvv = new TextField("Cvv: ");
        TextField textFieldFirstName = new TextField("First Name: ");
        TextField textFieldLastName = new TextField("Last Name: ");

        Button payButton = new Button("Pay");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        addComponents(formHeader, textFieldDebtId, textFieldSsn, textFieldAmount, creditCartHeader,textFieldFirstName, textFieldLastName,  textFieldccNumber
                , textFieldCvv, textFieldExpDate, payButton);
    }


}