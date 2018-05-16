package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.junit.Assert;
import org.junit.Test;

public class UuidValidatoTest {
    private UuidValidator uuidValidator = new UuidValidator();

    private String uuid;

    @Test
    public void shouldValidateAsOkWhenCorrectUuid() {
        //given
        uuid = "111222333444";
        //when then
        Assert.assertFalse(uuidValidator.apply(uuid, new ValueContext()).isError());
    }


    @Test
    public void shouldNotValidateWhenUuidContainsChars() {
        //given
        uuid = "ardf4";
        //when then
        Assert.assertTrue(uuidValidator.apply(uuid, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenLengthNotEqual12() {
        //given
        uuid = "12345";
        //when then
        Assert.assertTrue(uuidValidator.apply(uuid, new ValueContext()).isError());
    }

}
