package eu.sii.pl.velka.ui.views.components;

import com.vaadin.annotations.PropertyId;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.ui.views.AbstractDataForm;


public class CreditCardLayout extends AbstractDataForm<CreditCard> {
    private Label creditCartHeader = new Label("Credit Card data:");

    @PropertyId("ccNumber")
    private TextField textFieldccNumber = new TextField("CcNumber: ");

    @PropertyId("issuingNetwork")
    private TextField textFieldissuingNetwork = new TextField("Issuing Network: ");

    @PropertyId("expDate")
    private TextField textFieldExpDate = new TextField("Expire Date: ");

    @PropertyId("cvv")
    private TextField textFieldCvv = new TextField("Cvv: ");

    @PropertyId("firstName")
    private TextField textFieldFirstName = new TextField("First Name: ");

    @PropertyId("lastName")
    private TextField textFieldLastName = new TextField("Last Name: ");

    @Override
    protected Class<CreditCard> getModelClass() {
        return CreditCard.class;
    }
}
