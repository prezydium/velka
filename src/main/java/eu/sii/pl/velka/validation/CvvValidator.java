package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

import static com.vaadin.data.ValidationResult.error;
import static com.vaadin.data.ValidationResult.ok;

public class CvvValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String cvvNumber, ValueContext valueContext) {
        if (nullOrEmpty(cvvNumber)) return error("CVV number cannot be empty");
        if (!onlyDigits(cvvNumber)) return error("CVV number can only contain digits");
        if (lengthIsNotThree(cvvNumber)) return error("CVV number must have 3 digits");
        return ok();
    }

    private boolean lengthIsNotThree(String cvvNumber) {
        return (cvvNumber.length() != 3);
    }

    private boolean onlyDigits(String cvvNumber) {
        return (cvvNumber.matches("[0-9]*$"));
    }

    private boolean nullOrEmpty(String cvvNumber) {
        return ((cvvNumber == null) || cvvNumber.isEmpty());
    }
}
