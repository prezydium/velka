package eu.sii.pl.velka.validation;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.ValueContext;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SsnValidatorTest {

    private SsnValidator ssnValidator = new SsnValidator();

    private String ssn;

    @Test
    public void shouldValidateAsOkWhenCorrectSsn() {
        //given
        ssn = "999-111-222";
        //when then
        assertFalse(ssnValidator.apply(ssn, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenEmptyString() {
        //given
        ssn = "";
        //when
        ValidationResult result=ssnValidator.apply(ssn, new ValueContext());
        //then
        assertTrue(result.isError());
    }

    @Test
    public void shouldNotValidateWhenSsnContainsChars() {
        //given
        String name = "222-22Z-222";
        //then
        assertTrue(ssnValidator.apply(name, new ValueContext()).isError());
    }
    @Test
    public void shouldIgnoreDashes() {
        //given
        String name = "22-2--------222222";
        //then
        assertFalse(ssnValidator.apply(name, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenLessThanNineDigits() {
        //given
        String name = "111";
        //then
        Assert.assertTrue(ssnValidator.apply(name, new ValueContext()).isError());
    }
    @Test
    public void shouldNotValidateWhenMoreThanNineDigits() {
        //given
        String name = "1234567890";
        //then
        Assert.assertTrue(ssnValidator.apply(name, new ValueContext()).isError());
    }
}