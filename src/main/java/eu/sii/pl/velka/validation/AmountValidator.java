package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

import static com.vaadin.data.ValidationResult.error;
import static com.vaadin.data.ValidationResult.ok;

public class AmountValidator implements Validator<String> {


    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (nullOrEmpty(s)) return error("Payment amount cannot be empty");
        if (notProperFormatInOnlyDigitsAndPoint(s)) return error("Payment amount should be in 00.00 format");
        return ok();
    }

    private boolean nullOrEmpty(String s) {
        return ((s == null) || s.isEmpty());
    }

    private boolean notProperFormatInOnlyDigitsAndPoint(String s) {
        return (!s.matches("[0-9]+([.][0-9]{1,2})?"));
    }
}
