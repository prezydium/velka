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
    //given
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

        Set<Debt> debts = new HashSet<Debt>(Arrays.asList(debt, debt1));
        Set<Debt> debtsNullPayment = new HashSet<Debt>(Arrays.asList(debtNullPayments));
        debtor = new Debtor("Ana", "Smith", "232122333", debts);
        debtorWithNullPayments = new Debtor("Ana", "Smith", "232122333", debtsNullPayment);



    }


    @Test
    public void getDebtsSumTest(){
        //given
        //when
        BigDecimal debtsSumAmount= DebtorSummaryData.getDebtsSum(debtor);
        //then
        Assert.assertThat(debtsSumAmount,CoreMatchers.equalTo(new BigDecimal(600)));

    }
    @Test
    public void getPaymentsSumTest(){
        //given
        //when
        BigDecimal paymentsSumAmount= DebtorSummaryData.getPaymentsSum(debtor);
        //then
        Assert.assertThat(paymentsSumAmount,CoreMatchers.equalTo(new BigDecimal(320.00).setScale(2, RoundingMode.HALF_EVEN)));

    } @Test
    public void getPaymentsSumWhenNullTest(){
        //given
        //when
        BigDecimal paymentsSumAmount= DebtorSummaryData.getPaymentsSum(debtorWithNullPayments);
        //then
        Assert.assertThat(paymentsSumAmount,CoreMatchers.equalTo(new BigDecimal(0)));

    }


}
