package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

import static com.vaadin.data.ValidationResult.error;
import static com.vaadin.data.ValidationResult.ok;

public class CvvValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String cvvNumber, ValueContext valueContext) {
        return ((cvvNumber == null) || cvvNumber.isEmpty()) ? error("CVV number cannot be empty")
                : ((!cvvNumber.matches("[0-9]*$")) ? error("CVV number can only contain digits")
                : (cvvNumber.length() != 3) ? error("Credit card number must have 3 digits")
                : ok());
    }
}
