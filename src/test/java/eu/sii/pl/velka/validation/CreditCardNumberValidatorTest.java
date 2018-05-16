package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CreditCardNumberValidatorTest {

    private String ccNumber;
    private CreditCardNumberValidator creditCardNumberValidator;

    @Before
    public void setUp() {
        creditCardNumberValidator = new CreditCardNumberValidator();
    }

    @Test
    public void shouldValidateProperNumber() {
        //given
        ccNumber = "1234567890123456";
        //then
        Assertions.assertThat(creditCardNumberValidator.apply(ccNumber, new ValueContext()).isError()).isEqualTo(false);
    }

    @Test
    public void shouldValidateNumberWithSpaces(){
        //given
        ccNumber = "1 23456789 0123456";
        //then
        Assertions.assertThat(creditCardNumberValidator.apply(ccNumber, new ValueContext()).isError()).isEqualTo(false);
    }

    @Test
    public void shouldNotValidateNumberWithChar(){
        //given
        ccNumber = "123456789O123456";
        //then
        Assertions.assertThat(creditCardNumberValidator.apply(ccNumber, new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldNotValidateOverSixteenDigits(){
        //given
        ccNumber = "123456789O123456789";
        //then
        Assertions.assertThat(creditCardNumberValidator.apply(ccNumber, new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldNotValidateUnderSixteenDigits(){
        //given
        ccNumber = "123";
        //then
        Assertions.assertThat(creditCardNumberValidator.apply(ccNumber, new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldNotValidateNullNumber(){
        Assertions.assertThat(creditCardNumberValidator.apply(null, new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldNotValidateEmptyNumber(){
        Assertions.assertThat(creditCardNumberValidator.apply("", new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldHaveErrorMsgForEveryValidationFailure(){
        Assertions.assertThat(creditCardNumberValidator.apply("00000000000000000000", new ValueContext()).getErrorMessage()).isNotEmpty();
        Assertions.assertThat(creditCardNumberValidator.apply("123456ABCDEFGHIJ", new ValueContext()).getErrorMessage()).isNotEmpty();
        Assertions.assertThat(creditCardNumberValidator.apply("", new ValueContext()).getErrorMessage()).isNotEmpty();
        Assertions.assertThat(creditCardNumberValidator.apply(null, new ValueContext()).getErrorMessage()).isNotEmpty();
        }
}