package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.dataHolder.DebtCreator;
import eu.sii.pl.velka.model.Debt;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DebtSummaryDataUtilTest {

    private Debt debt;

    @Test
    public void shouldReturnRepaymentAmount() {
        //given
        debt = DebtCreator.createDebt();
        //when
        BigDecimal remainingAmount = DebtSummaryDataUtil.getSumPaymentsAmount(debt);
        //then
        assertThat(remainingAmount, equalTo(new BigDecimal(160).setScale(2)));
    }
}
