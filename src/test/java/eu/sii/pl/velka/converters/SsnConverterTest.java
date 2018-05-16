package eu.sii.pl.velka.converters;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SsnConverterTest {

    private String result;

    @Test
    public void ShouldConvertSsnToThreeIntegersDashThreeIntegersDashThreeIntegers() {
        //given
        String s = "980122111";
        String expected = "980-122-111";
        //when
        result = new SsnConverter().convertSsnToFormatAcceptableByAPI(s);
        //then
        Assert.assertTrue(result.equals(expected));
    }
    @Test
    public void ShouldIgnoreDashesEnteredByUser() {
        //given
        String s = "123456789";
        StringBuilder sb = new StringBuilder(s);
        sb.insert(3, '-');
        sb.insert(4, '-');
        sb.insert(10, '-');
        String expected = "123-456-789";
        //when
        result = new SsnConverter().convertSsnToFormatAcceptableByAPI(sb.toString());
        //then
        Assert.assertTrue(result.equals(expected));
    }
}
