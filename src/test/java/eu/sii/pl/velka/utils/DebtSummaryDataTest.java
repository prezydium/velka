package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DebtSummaryDataTest {

    //given
    Debt debt;
    Debt debtWithNullPayments;

    @Before
    public void init() {
        CreditCard creditCard = new CreditCard(
                "232345", "222", "Ana", "Smith");
        Payment payment = new Payment(1L, LocalDate.now(), new BigDecimal(30), creditCard, null);
        Payment payment1 = new Payment(1L, LocalDate.now(), new BigDecimal(130), creditCard, null);
        Set<Payment> payments = new HashSet<Payment>(Arrays.asList(payment, payment1));

      debt = new Debt(1L, new BigDecimal(200), LocalDate.now(), payments);
      debtWithNullPayments = new Debt(1L, new BigDecimal(200), LocalDate.now(), null);
    }

    @Test
    public void shouldReturnRemainingAmount(){
        //when
        BigDecimal remainingAmount= DebtSummaryData.getRemainingAmount(debt);
        //then
        Assert.assertThat(remainingAmount,CoreMatchers.equalTo(new BigDecimal(40).setScale(2, RoundingMode.HALF_EVEN)));

    }
 @Test
    public void shouldReturnRemainingAmountWhenNullPayments(){
        //when
        BigDecimal sumPaymentAmount= DebtSummaryData.getRemainingAmount(debtWithNullPayments);
        //then
        Assert.assertThat(sumPaymentAmount,CoreMatchers.equalTo(debtWithNullPayments.getDebtAmount()));

    }

}
