package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class SsnValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (s == null || s.isEmpty()) {
            return ValidationResult.error("Social security number cannot be empty");
        } else if (s.length() < 9 || s.length() > 11) {
            return ValidationResult.error("Social security number must have 9 digits");
        } else {
            return ValidationResult.ok();
        }
    }
}
