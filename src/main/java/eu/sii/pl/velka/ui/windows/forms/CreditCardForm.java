package eu.sii.pl.velka.ui.windows.forms;

import com.vaadin.annotations.PropertyId;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.DateField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.ui.views.AbstractDataForm;
import eu.sii.pl.velka.validation.CreditCardNumberValidator;
import eu.sii.pl.velka.validation.CvvValidator;
import eu.sii.pl.velka.validation.NameValidator;


public class CreditCardForm extends AbstractDataForm {

    public static final String PAYMENT_METHOD_NAME = "creditCard";

    @PropertyId("ccNumber")
    private TextField ccNumber = new TextField("Credit card number:");

    @PropertyId("cvv")
    private TextField cvv = new TextField("CVV number:");

    @PropertyId("issuingNetwork")
    private RadioButtonGroup<String> issuingNetworkButtons = new RadioButtonGroup<>("Issuing Network");

    @PropertyId("expDate")
    private DateField expDate = new DateField("Expiration date:");

    @PropertyId("firstName")
    private TextField firstName = new TextField("First name");

    @PropertyId("lastName")
    private TextField lastName = new TextField("Last name:");

    public CreditCardForm(Debtor debtor) {
        super();
        setModel(new CreditCard());
        issuingNetworkButtons.setItems("Visa", "MasterCard");
        expDate.setDateFormat("MM/yy");
        setUpValidation();
        binder.bindInstanceFields(this);
        setDebtorData(debtor);
        this.setSpacing(true);
        this.addComponents(ccNumber, cvv, issuingNetworkButtons, expDate, firstName, lastName);
    }

    private void setDebtorData(Debtor debtor) {
        firstName.setValue(debtor.getFirstName());
        lastName.setValue(debtor.getLastName());
    }

    private void setUpValidation() {
        ccNumber.setValueChangeMode(ValueChangeMode.BLUR);
        cvv.setValueChangeMode(ValueChangeMode.BLUR);
        firstName.setValueChangeMode(ValueChangeMode.BLUR);
        lastName.setValueChangeMode(ValueChangeMode.BLUR);
        binder.forMemberField(ccNumber)
                .withValidator(new CreditCardNumberValidator())
                .asRequired();
        binder.forMemberField(cvv)
                .withValidator(new CvvValidator())
                .asRequired();
        binder.forMemberField(issuingNetworkButtons)
                .asRequired();
        binder.forMemberField(expDate)
                .asRequired();
        binder.forMemberField(firstName)
                .withValidator(new NameValidator())
                .asRequired();
        binder.forMemberField(lastName)
                .withValidator(new NameValidator())
                .asRequired();
    }

    @Override
    protected Class<CreditCard> getModelClass() {
        return CreditCard.class;
    }
}
