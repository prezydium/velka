package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.PlannedPayment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlannedPaymentTableView {
    private String uuid;
    private String debtName;
    private LocalDate expDate;
    private BigDecimal debtAmount;
    private BigDecimal sumPaymentAmount;
    private BigDecimal remainingAmount;
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

    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public BigDecimal getPlannedRepaymentAmount() {
        return plannedRepaymentAmount;
    }

    public BigDecimal getSumPaymentAmount() {
        return sumPaymentAmount;
    }

    public void setSumPaymentAmount(BigDecimal sumPaymentAmount) {
        this.sumPaymentAmount = sumPaymentAmount;
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

    public PlannedPaymentTableView(PlannedPayment plannedPayment, DebtTableView debt) {
        this.uuid = plannedPayment.getUuid();
        this.debtName = debt.getDebtViewName();
        this.expDate = debt.getDebtViewDate();
        this.debtAmount = debt.getDebtViewAmount();
        this.sumPaymentAmount=debt.getSumPaymentViewAmount();
        this.remainingAmount = debt.getRemainingAmountView();
        this.plannedRepaymentAmount = plannedPayment.getAmountOfRepaymentDebt();
        this.plannedRemainingDebtAmount =debt.getRemainingAmountView().subtract(plannedPayment.getAmountOfRepaymentDebt());
    }
}
