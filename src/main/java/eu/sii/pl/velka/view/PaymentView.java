package eu.sii.pl.velka.view;


import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = "payment")
public class PaymentView extends VerticalLayout implements View {

    private Label formHeader = new Label("Enter your details to pay your debts");
    private TextField textFieldDebtId = new TextField("debtUuid: ");
    private TextField textFieldAmount = new TextField("Amount: ");
    private TextField textFieldccNumber = new TextField("CcNumber: ");
    private TextField textFieldExpDate = new TextField("Expire Date: ");
    private TextField textFieldCvv = new TextField("Cvv: ");
    private TextField textFieldFirstName = new TextField("First Name: ");
    private TextField textFieldLastName = new TextField("Last Name: ");
    private TextField textFieldSsn = new TextField("SSN: ");

    public PaymentView() {

        addComponents(formHeader,textFieldDebtId,textFieldFirstName,textFieldLastName,textFieldSsn,textFieldAmount,textFieldccNumber
        ,textFieldCvv,textFieldExpDate);
    }

}
