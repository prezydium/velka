package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.junit.Assert;
import org.junit.Test;

public class AmountValidatorTest {

    private AmountValidator amountValidator=new AmountValidator();

    private String amount;

    @Test
    public void shouldValidateAsOkWhenCorrectAmount() {
        //given
        amount = "11444";
        //when then
        Assert.assertFalse(amountValidator.apply(amount, new ValueContext()).isError());
    }


    @Test
    public void shouldValidateAsOkWhenAmountisDecimalFormat() {
        //given
        amount = "114.44";
        //when then
        Assert.assertFalse(amountValidator.apply(amount, new ValueContext()).isError());
    }

    @Test
    public void shouldNotValidateWhenAmountContainCharts() {
        //given
        amount = "abc";
        //when then
        Assert.assertTrue(amountValidator.apply(amount, new ValueContext()).isError());
    }
    @Test
    public void shouldNotValidateWhenAmountisnull() {
        //given
        amount = null;
        //when then
        Assert.assertTrue(amountValidator.apply(amount, new ValueContext()).isError());
    }
}
