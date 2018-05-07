package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.junit.Assert;
import org.junit.Test;

public class NameValidatorTest {

    private NameValidator nameValidator = new NameValidator();

    @Test
    public void shouldValidateAsOkWhenNameIsWojtek() {
        //given
        String name = "Wojtek";

        //when then
        Assert.assertFalse(nameValidator.apply(name, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenEmptyString() {
        //given
        String name = "";

        //when then
        Assert.assertTrue(nameValidator.apply(name, new ValueContext()).isError());
    }
    @Test
    public void shouldNotValidateWhenNameContainsIntegers() {
        //given
        String name = "h4ckZoor";

        //when then
        Assert.assertTrue(nameValidator.apply(name, new ValueContext()).isError());
    }

}