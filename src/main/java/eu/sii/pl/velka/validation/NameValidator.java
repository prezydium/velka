package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import org.springframework.util.StringUtils;

public class NameValidator implements Validator<String> {

    @Override
    public ValidationResult apply(String nameToValidate, ValueContext valueContext) {
        if (StringUtils.isEmpty(nameToValidate)) {
            return ValidationResult.error("First or Last name cannot be empty");
        } else if (!nameToValidate.matches("^[a-zA-Z]+$")) {
            return ValidationResult.error("First or Last name should contain only letters");
        } else {
            return ValidationResult.ok();
        }
    }
}
