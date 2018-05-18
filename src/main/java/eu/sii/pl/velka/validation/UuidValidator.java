package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class UuidValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (s == null || s.isEmpty()) {
            return ValidationResult.ok();
        }
        if (!s.matches("[0-9a-zA-Z/]{11}?")) {
            return ValidationResult.error("Debt number must have 11 characters/digits");
        } else {
            return ValidationResult.ok();
        }
    }
}
//"[0-9a-zA-Z/]{11}?"