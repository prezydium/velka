package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.dataHolder.DebtCreator;
import eu.sii.pl.velka.dataHolder.DebtorCreator;
import eu.sii.pl.velka.model.Debt;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DebtSummaryDataTest {

    private Debt debt;

    private Debt debtWithNullPayments;

    @Test
    public void shouldReturnRemainingAmount() {
        //given
        debt = DebtCreator.createDebt();
        //when
        BigDecimal remainingAmount = DebtSummaryData.getRemainingAmount(debt);
        //then
        assertThat(remainingAmount, equalTo(new BigDecimal(40).setScale(2)));
    }

    @Test
    public void shouldReturnRemainingAmountWhithEmptyListOfPayments() {
        //given
        debtWithNullPayments = DebtCreator.createDebtWithNullPayments();
        //when
        BigDecimal sumPaymentAmount = DebtSummaryData.getRemainingAmount(debtWithNullPayments);
        //then
        assertThat(sumPaymentAmount, equalTo(debtWithNullPayments.getDebtAmount().setScale(2)));
    }
}
