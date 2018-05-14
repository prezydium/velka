package eu.sii.pl.velka.view;

import com.vaadin.annotations.PropertyId;
import com.vaadin.data.Binder;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debtor;

public class CreditCardForm extends VerticalLayout {

    @PropertyId("ccNumber")
    private TextField ccNumber = new TextField("Credit card number:");

    @PropertyId("cvv")
    private TextField cvv = new TextField("CVV number:");

    @PropertyId("issuingNetwork")
    private TextField issuingNetwork = new TextField("Issuing network");

    @PropertyId("expDate")
    private DateField expDate = new DateField("Expiration date:");

    @PropertyId("firstName")
    private TextField firstName = new TextField("First name");

    @PropertyId("lastName")
    private TextField lastName = new TextField("Last name:");

    private CreditCard creditCard = new CreditCard();

    VerticalLayout formLayout = new VerticalLayout();

    private Binder binder = new Binder(CreditCard.class);

    private Debtor debtor;

    public CreditCardForm(Debtor debtor) {
        this.debtor = debtor;
        expDate.setDateFormat("MM/yy");
        binder.setBean(creditCard);
        binder.bindInstanceFields(this);
        firstName.setValue(debtor.getFirstName());
        lastName.setValue(debtor.getLastName());
        this.addComponents(ccNumber, cvv, issuingNetwork, expDate, firstName, lastName);

    }
}
