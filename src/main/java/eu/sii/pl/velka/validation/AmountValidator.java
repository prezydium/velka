package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class AmountValidator implements Validator<String> {


    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (s == null || s.isEmpty()) {
            return ValidationResult.error("Payment amount cannot be empty");
        } else if (!s.matches("[0-9]+([.][0-9]{1,2})?")) {
            return ValidationResult.error("Payment amount should be in 00.00 format");
        } else {
            return ValidationResult.ok();
        }
    }
}
