package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.dataHolder.DebtCreator;
import eu.sii.pl.velka.model.Debt;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DebtSummaryDataUtilTest {

    private Debt debt;

    private Debt debtWithNullPayments;

    @Test
    public void shouldReturnRemainingAmount() {
        //given
        debt = DebtCreator.createDebt();
        //when
        BigDecimal remainingAmount = DebtSummaryDataUtil.getSumPaymentsAmount(debt);
        //then
        assertThat(remainingAmount, equalTo(new BigDecimal(40).setScale(2)));
    }

    @Test
    public void shouldReturnRemainingAmountWhithEmptyListOfPayments() {
        //given
        debtWithNullPayments = DebtCreator.createDebtWithNullPayments();
        //when
        BigDecimal sumPaymentAmount = DebtSummaryDataUtil.getSumPaymentsAmount(debtWithNullPayments);
        //then
        assertThat(sumPaymentAmount, equalTo(debtWithNullPayments.getDebtAmount().setScale(2)));
    }
}
