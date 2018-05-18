package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.junit.Assert;
import org.junit.Test;

public class UuidValidatorTest {
    private UuidValidator uuidValidator = new UuidValidator();

    private String uuid;

    @Test
    public void shouldValidateAsOkWhenCorrectUuid() {
        //given
        uuid = "11122233344";
        //when then
        Assert.assertFalse(uuidValidator.apply(uuid, new ValueContext()).isError());
    }

    @Test
    public void shouldValidateAsOkWhenCorrectUuidWithLettersAndSlash() {
        //given
        uuid = "aAa/2223334";
        //when then
        Assert.assertFalse(uuidValidator.apply(uuid, new ValueContext()).isError());
    }


    @Test
    public void shouldNotValidateWhenUuidIsLessThanElevenSymbols() {
        //given
        uuid = "ardf4";
        //then
        Assert.assertTrue(uuidValidator.apply(uuid, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenLengthIsOverEleven() {
        //given
        uuid = "123456789012";
        // then
        Assert.assertTrue(uuidValidator.apply(uuid, new ValueContext()).isError());
    }

}
