package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.dataHolder.DebtorCreator;
import eu.sii.pl.velka.model.Debtor;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DebtorSummaryDataUtilTest {

    private Debtor debtor;

    @Test
    public void shouldReturnDebtsSum(){
        //given
        debtor = DebtorCreator.createDebtor();
        //when
        BigDecimal debtsSumAmount= DebtorSummaryDataUtil.getDebtsSum(debtor);
        //then
        assertThat(debtsSumAmount,equalTo(new BigDecimal(600).setScale(2)));
    }

    @Test
    public void shouldReturnRemainingAmountSum(){
        //given
        debtor = DebtorCreator.createDebtor();
        //when
        BigDecimal remainingAmountSum= DebtorSummaryDataUtil.getRemainingAmountSum(debtor);
        //then
        assertThat(remainingAmountSum,equalTo(new BigDecimal(280).setScale(2)));
    }
}
