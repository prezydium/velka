package eu.sii.pl.velka.ui.viewModel;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.utils.DebtSummaryDataUtil;

import java.math.BigDecimal;
import java.time.LocalDate;


public class DebtTableView {

    private String debtViewName;
    private String uuid;
    private LocalDate debtViewDate;
    private BigDecimal debtViewAmount;
    private BigDecimal sumRemainingViewAmount;
    private BigDecimal sumPaymentViewAmount;

    public LocalDate getDebtViewDate() {
        return debtViewDate;
    }

    public BigDecimal getDebtViewAmount() {
        return debtViewAmount;
    }

    public BigDecimal getRemainingAmountView() {
        return sumRemainingViewAmount;
    }

    public String getDebtViewName() {
        return debtViewName;
    }

    public String getUuid() {
        return uuid;
    }

    public BigDecimal getSumPaymentViewAmount() {
        return sumPaymentViewAmount;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setDebtViewName(String debtViewName) {
        this.debtViewName = debtViewName;
    }

    public void setDebtViewDate(LocalDate debtViewDate) {
        this.debtViewDate = debtViewDate;
    }

    public void setDebtViewAmount(BigDecimal debtViewAmount) {
        this.debtViewAmount = debtViewAmount;
    }

    public void setSumPaymentViewAmount(BigDecimal sumRemainingViewAmount) {
        this.sumRemainingViewAmount = sumRemainingViewAmount;
    }

    public DebtTableView() {
    }

    public DebtTableView(Debt debt) {
        this.debtViewName = debt.getDebtName();
        this.uuid = debt.getUuid();
        this.debtViewDate = debt.getRepaymentDate();
        this.debtViewAmount = debt.getDebtAmount();
        this.sumRemainingViewAmount = debt.getDebtAmount().subtract(DebtSummaryDataUtil.getSumPaymentsAmount(debt));
        this.sumPaymentViewAmount = DebtSummaryDataUtil.getSumPaymentsAmount(debt);
    }

    @Override
    public String toString() {
        return "DebtTableView{" +
                "debtViewName='" + debtViewName + '\'' +
                ", uuid='" + uuid + '\'' +
                ", debtViewDate=" + debtViewDate +
                ", debtViewAmount=" + debtViewAmount +
                ", sumRemainingViewAmount=" + sumRemainingViewAmount +
                ", sumPViewAmount=" + sumPaymentViewAmount +
                '}';
    }
}
