package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class UuidValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
         if (!s.matches("[0-9]{12}?")) {
            return ValidationResult.error("Debt number must have 12 digits");
        } else {
            return ValidationResult.ok();
        }
    }
}
