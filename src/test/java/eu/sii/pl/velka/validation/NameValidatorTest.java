package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.junit.Assert;
import org.junit.Test;

public class NameValidatorTest {

    private NameValidator nameValidator = new NameValidator();

    @Test
    public void shouldValidateAsOk() {
        //given
        String name = "Wojtek";

        //when then
        Assert.assertFalse(nameValidator.apply(name, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidate() {
        //given
        String name = "";

        //when then
        Assert.assertFalse(nameValidator.apply(name, new ValueContext()).isError());
    }
}