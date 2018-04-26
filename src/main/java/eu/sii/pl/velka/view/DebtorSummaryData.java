package eu.sii.pl.velka.view;


import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DebtorSummaryData {

    private final String amountSum;
    private final String paymentsSum;

    public DebtorSummaryData(List<Debt> listDebts) {
        this.amountSum = calculateAmountSum(listDebts);
        this.paymentsSum = calculatePaymentsSum(listDebts);
    }


    public String getAmountSum() {
        return amountSum;
    }

    public String getPaymentsSum() {
        return paymentsSum;
    }

    private String calculateAmountSum(List<Debt> listDebts) {
        BigDecimal sumAmount= listDebts.stream().map(Debt::getDebtValue).reduce(BigDecimal::add).get();
        return sumAmount.toString();
    }

    private String calculatePaymentsSum(List<Debt> listDebts){
        List<BigDecimal> allPayments=new ArrayList<>();
//
//        for (Debt item : listDebts) {
//            BigDecimal debtPaymentsSum = item.getPayments().stream()
//                    .map(Payment::getValue)
//                    .reduce(BigDecimal.ZERO, BigDecimal::add)
//                    .setScale(2, RoundingMode.HALF_EVEN);
//            allPayments.add(debtPaymentsSum);
//        }
//        return allPayments.stream()
//                .reduce(BigDecimal.ZERO, BigDecimal::add)
//                .setScale(2, RoundingMode.HALF_EVEN)
//                .toString();
        return null;
    }
}
