package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

import static com.vaadin.data.ValidationResult.error;
import static com.vaadin.data.ValidationResult.ok;

public class CreditCardNumberValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String ccNumber, ValueContext valueContext) {
        if (nullOrEmpty(ccNumber)) return error("Credit card number cannot be empty");
        if (notOnlyDigitsOrSpaces(ccNumber)) return error("Credit card number can only contain digits");
        if (lengthIsNotNine(ccNumber)) return error("Credit card number must have 16 digits");
        return ok();

    }

    private boolean lengthIsNotNine(String ccNumber) {
        return (ccNumber.replace(" ", "").length() != 16);
    }

    private boolean notOnlyDigitsOrSpaces(String ccNumber) {
        return (!ccNumber.matches("[0-9\\s]*$"));
    }

    private boolean nullOrEmpty(String ccNumber) {
        return ((ccNumber == null) || ccNumber.isEmpty());
    }
}
