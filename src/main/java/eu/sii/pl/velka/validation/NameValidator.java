package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class NameValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (s == null || s.isEmpty() || s.equals("")) {
            return ValidationResult.error("First or Last name cannot be empty");
        } else if (s.contains(" ")) {
            return ValidationResult.error("First or Last name cannot have spaces");
        } else {
            return ValidationResult.ok();
        }
    }

}
