package eu.sii.pl.velka.validation;

import com.vaadin.data.ValueContext;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CvvValidatorTest {

    private String cvvNumber;
    private CvvValidator cvvValidator;

    @Before
    public void setUp() {
        cvvValidator = new CvvValidator();
    }

    @Test
    public void shouldValidateProperCvvNumber() {
        //given
        cvvNumber = "123";
        //then
        Assertions.assertThat(cvvValidator.apply(cvvNumber, new ValueContext()).isError()).isEqualTo(false);
    }

    @Test
    public void shouldNotValidateNumberWithChar() {
        //given
        cvvNumber = "BD3";
        //then
        Assertions.assertThat(cvvValidator.apply(cvvNumber, new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldNotValidateOverThreeDigits() {
        //given
        cvvNumber = "1234";
        //then
        Assertions.assertThat(cvvValidator.apply(cvvNumber, new ValueContext()).isError()).isEqualTo(true);
    }
    @Test
    public void shouldNotValidateUnderThreeDigits() {
        //given
        cvvNumber = "12";
        //then
        Assertions.assertThat(cvvValidator.apply(cvvNumber, new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldNotValidateNullNumber() {
        Assertions.assertThat(cvvValidator.apply(null, new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldNotValidateEmptyNumber() {
        Assertions.assertThat(cvvValidator.apply("", new ValueContext()).isError()).isEqualTo(true);
    }

    @Test
    public void shouldHaveErrorMsgForEveryValidationFailure() {
        Assertions.assertThat(cvvValidator.apply("00000000000000000000", new ValueContext()).getErrorMessage()).isNotEmpty();
        Assertions.assertThat(cvvValidator.apply("12A", new ValueContext()).getErrorMessage()).isNotEmpty();
        Assertions.assertThat(cvvValidator.apply("", new ValueContext()).getErrorMessage()).isNotEmpty();
        Assertions.assertThat(cvvValidator.apply(null, new ValueContext()).getErrorMessage()).isNotEmpty();
    }
}
