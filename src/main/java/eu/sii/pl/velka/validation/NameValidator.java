package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class NameValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (s == null || s.isEmpty() ) {
            return ValidationResult.error("First or Last name cannot be empty");
        } else if (!s.matches("^[a-zA-Z]+$")) {
            return ValidationResult.error("First or Last name should contain only letters");
        } else {
            return ValidationResult.ok();
        }
    }
}
