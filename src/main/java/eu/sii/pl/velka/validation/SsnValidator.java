package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class SsnValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (s == null || s.isEmpty()) {
            return ValidationResult.error("Social security number cannot be empty");
        } else if(!s.matches("^[0-9\\-]*$")){
            return ValidationResult.error("Social security number can only contain digits");
        } else if (s.replace("-", "").length() != 9 ) {
            return ValidationResult.error("Social security number must have 9 digits");
        } else {
            return ValidationResult.ok();
        }
    }
}
