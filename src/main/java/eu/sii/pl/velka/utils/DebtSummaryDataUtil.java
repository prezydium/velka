package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DebtSummaryDataUtil {

    private DebtSummaryDataUtil() {
    }

    public static BigDecimal getSumPaymentsAmount(Debt debt) {
        BigDecimal debtPaymentsSum = debt.getPayments().stream()
                .map(Payment::getPaymentAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);
        return debtPaymentsSum;
    }
}
