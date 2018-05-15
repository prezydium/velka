package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

import static com.vaadin.data.ValidationResult.error;
import static com.vaadin.data.ValidationResult.ok;

public class CreditCardNumberValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String ccNumber, ValueContext valueContext) {
        return ((ccNumber == null) || ccNumber.isEmpty()) ? error("Credit card number cannot be empty")
                : ((!ccNumber.matches("[0-9\\s]*$")) ? error("Credit card number can only contain digits")
                : ((ccNumber.replace(" ", "").length() != 16) ? error("Credit card number must have 16 digits")
                : ok()));
    }
}
