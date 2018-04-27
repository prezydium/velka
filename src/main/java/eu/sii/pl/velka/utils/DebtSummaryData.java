package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DebtSummaryData {

    public DebtSummaryData() {
    }


    public static BigDecimal getSumPaymentAmount(Debt debt) {


        if (debt.getPayments() == null || debt.getPayments().isEmpty()) {

            return new BigDecimal(0.0);
        } else {
            BigDecimal debtPaymentsSum = debt.getPayments().stream()
                    .map(Payment::getValue)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .setScale(2, RoundingMode.HALF_EVEN);
            return debtPaymentsSum;
        }
    }

}
