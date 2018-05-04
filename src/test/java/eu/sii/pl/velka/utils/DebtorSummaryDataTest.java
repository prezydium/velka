package eu.sii.pl.velka.utils;
import eu.sii.pl.velka.dataHolder.DebtorCreator;
import eu.sii.pl.velka.model.Debtor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class DebtorSummaryDataTest {

    @Autowired
    DebtorCreator debtorCreator;
    Debtor debtor;

    @Test
    public void shouldReturnDebtsSum(){
        //given
        debtor = debtorCreator.createDebtor();
        //when
        BigDecimal debtsSumAmount= DebtorSummaryData.getDebtsSum(debtor);
        //then
        assertThat(debtsSumAmount,equalTo(new BigDecimal(600).setScale(2)));
    }

    @Test
    public void shouldReturnRemainingAmountSum(){
        //given
        debtor = debtorCreator.createDebtor();
        //when
        BigDecimal remainingAmountSum= DebtorSummaryData.getRemainingAmountSum(debtor);
        //then
        assertThat(remainingAmountSum,equalTo(new BigDecimal(280).setScale(2)));
    }
}
