package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.junit.Assert;
import org.junit.Test;

public class SsnValidatorTest {

    private SsnValidator ssnValidator = new SsnValidator();

    private String ssn;

    @Test
    public void shouldValidateAsOkWhenCorrectSsn() {
        //given
        ssn = "999-111-222";
        //when then
        Assert.assertFalse(ssnValidator.apply(ssn, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenEmptyString() {
        //given
        ssn = "";
        //then
        Assert.assertTrue(ssnValidator.apply(ssn, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenSsnContainsChars() {
        //given
        String name = "222-22Z-222";
        //then
        Assert.assertTrue(ssnValidator.apply(name, new ValueContext()).isError());
    }
    @Test
    public void shouldIgnoreDashes() {
        //given
        String name = "22-2--------222222";
        //then
        Assert.assertFalse(ssnValidator.apply(name, new ValueContext()).isError());
    }
}