package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.PlannedPayment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlannedPaymentTableView {
    private String uuid;
    private String debtName;
    private LocalDate expDate;
    private BigDecimal debtAmount;
    private BigDecimal payedSum;
    private BigDecimal plannedRepaymentAmount;
    private BigDecimal plannedRemainingDebtAmount;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDebtName() {
        return debtName;
    }

    public void setDebtName(String debtName) {
        this.debtName = debtName;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(BigDecimal debtAmount) {
        this.debtAmount = debtAmount;
    }

    public BigDecimal getPayedSum() {
        return payedSum;
    }

    public void setPayedSum(BigDecimal payedSum) {
        this.payedSum = payedSum;
    }

    public BigDecimal getPlannedRepaymentAmount() {
        return plannedRepaymentAmount;
    }

    public void setPlannedRepaymentAmount(BigDecimal plannedRepaymentAmount) {
        this.plannedRepaymentAmount = plannedRepaymentAmount;
    }

    public BigDecimal getPlannedRemainingDebtAmount() {
        return plannedRemainingDebtAmount;
    }

    public void setPlannedRemainingDebtAmount(BigDecimal plannedRemainingDebtAmount) {
        this.plannedRemainingDebtAmount = plannedRemainingDebtAmount;
    }

    public PlannedPaymentTableView() {
    }

    public PlannedPaymentTableView(PlannedPayment plannedPayment) {
        this.uuid = plannedPayment.getUuid();
        this.debtName = debtName;
        this.expDate = expDate;
        this.debtAmount = plannedPayment.getAmountOfRepaymentDebt();
        this.payedSum = payedSum;
        this.plannedRepaymentAmount = plannedRepaymentAmount;
        this.plannedRemainingDebtAmount = plannedRemainingDebtAmount;
    }
}
