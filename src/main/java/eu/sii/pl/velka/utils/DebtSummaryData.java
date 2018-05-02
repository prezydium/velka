package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DebtSummaryData {

    public DebtSummaryData() {
    }


    public static BigDecimal getRemainingAmount(Debt debt) {


        if (debt.getListOfPayments() == null || debt.getListOfPayments().isEmpty()) {

            return debt.getDebtAmount();
        } else {
            BigDecimal debtPaymentsSum = debt.getListOfPayments().stream()
                    .map(Payment::getPaymentAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .setScale(2, RoundingMode.HALF_EVEN);
            return debt.getDebtAmount().subtract(debtPaymentsSum);
        }
    }

}
