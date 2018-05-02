package eu.sii.pl.velka.utils;
import eu.sii.pl.velka.dataHolder.DebtorCreator;
import eu.sii.pl.velka.model.Debtor;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.Assert;
import java.math.BigDecimal;

public class DebtorSummaryDataTest {

    DebtorCreator debtorCreator=new DebtorCreator();
    Debtor debtor;



    @Test
    public void shouldReturnDebtsSum(){
        //given
        debtor = debtorCreator.createDebtor();
        //when
        BigDecimal debtsSumAmount= DebtorSummaryData.getDebtsSum(debtor);
        //then
        Assert.assertThat(debtsSumAmount,CoreMatchers.equalTo(new BigDecimal(600).setScale(2)));

    }
    @Test
    public void shouldReturnRemainingAmountSum(){
        //given
        debtor = debtorCreator.createDebtor();
        //when
        BigDecimal remainingAmountSum= DebtorSummaryData.getRemainingAmountSum(debtor);
        //then
        Assert.assertThat(remainingAmountSum,CoreMatchers.equalTo(new BigDecimal(280).setScale(2)));

    }



}
