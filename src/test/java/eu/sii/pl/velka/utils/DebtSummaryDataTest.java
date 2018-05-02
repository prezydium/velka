package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.dataHolder.DebtCreator;
import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class DebtSummaryDataTest {

    DebtCreator debtCreator = new DebtCreator();
    Debt debt;
    Debt debtWithNullPayments;



    @Test
    public void shouldReturnRemainingAmount() {
        //given
        debt = debtCreator.createDebt();
        //when
        BigDecimal remainingAmount = DebtSummaryData.getRemainingAmount(debt);
        //then
        Assert.assertThat(remainingAmount, CoreMatchers.equalTo(new BigDecimal(40).setScale(2)));

    }

    @Test
    public void shouldReturnRemainingAmountWhenNullPayments() {
        //given
        debtWithNullPayments = debtCreator.createDebtWithNullPayments();
        //when
        BigDecimal sumPaymentAmount = DebtSummaryData.getRemainingAmount(debtWithNullPayments);
        //then
        Assert.assertThat(sumPaymentAmount, CoreMatchers.equalTo(debtWithNullPayments.getDebtAmount()));

    }

}
