package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.Payment;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

public class DebtorSummaryDataTest {

    Debtor debtor;
    Debtor debtorWithNullPayments;


    @Before
    public void init() {

        CreditCard creditCard = new CreditCard(
                "232345", "222", "Ana", "Smith");
        Payment payment = new Payment(1L, LocalDate.now(), new BigDecimal(30), creditCard, null);
        Payment payment1 = new Payment(1L, LocalDate.now(), new BigDecimal(130), creditCard, null);
        Set<Payment> payments = new HashSet<Payment>(Arrays.asList(payment, payment1));

        Debt debt = new Debt(1L, new BigDecimal(200), LocalDate.now(), payments);
        Debt debt1 = new Debt(1L, new BigDecimal(400), LocalDate.now(), payments);
        Debt debtNullPayments = new Debt(1L, new BigDecimal(400), LocalDate.now(), null);

        List<Debt> debts = new ArrayList<>(Arrays.asList(debt, debt1));
        List<Debt> debtsNullPayment = new ArrayList<>(Arrays.asList(debtNullPayments));
        debtor = new Debtor("Ana", "Smith", "232122333", debts);
        debtorWithNullPayments = new Debtor("Ana", "Smith", "232122333", debtsNullPayment);



    }


    @Test
    public void shouldReturnDebtsSum(){
        //given
        //when
        BigDecimal debtsSumAmount= DebtorSummaryData.getDebtsSum(debtor);
        //then
        Assert.assertThat(debtsSumAmount,CoreMatchers.equalTo(new BigDecimal(600).setScale(2)));

    }
    @Test
    public void shouldReturnRemainingAmountSum(){
        //given
        //when
        BigDecimal remainingAmountSum= DebtorSummaryData.getRemainingAmountSum(debtor);
        //then
        Assert.assertThat(remainingAmountSum,CoreMatchers.equalTo(new BigDecimal(280).setScale(2)));

    } @Test
    public void shouldReturnRemainingAmountSumWhenNullPayments(){
        //given
        //when
        BigDecimal remainingAmountSum= DebtorSummaryData.getRemainingAmountSum(debtorWithNullPayments);
        //then
        Assert.assertThat(remainingAmountSum,CoreMatchers.equalTo(DebtorSummaryData.getDebtsSum(debtorWithNullPayments)));

    }


}
