package eu.sii.pl.velka.view.viewModel;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.utils.DebtSummaryData;
import java.math.BigDecimal;


public class DebtTableView {

    Long debtViewId;
    String debtViewDate;
    BigDecimal debtViewAmount;
    BigDecimal sumPaymentViewAmount = new BigDecimal(0.0);


    public Long getDebtViewId() {
        return debtViewId;
    }

    public String getDebtViewDate() {
        return debtViewDate;
    }

    public BigDecimal getDebtViewAmount() {
        return debtViewAmount;
    }

    public BigDecimal getSumPaymentViewAmount() {
        return sumPaymentViewAmount;
    }

    public void setDebtViewId(Long debtViewId) {
        this.debtViewId = debtViewId;
    }

    public void setDebtViewDate(String debtViewDate) {
        this.debtViewDate = debtViewDate;
    }

    public void setDebtViewAmount(BigDecimal debtViewAmount) {
        this.debtViewAmount = debtViewAmount;
    }

    public void setSumPaymentViewAmount(BigDecimal sumPaymentViewAmount) {
        this.sumPaymentViewAmount = sumPaymentViewAmount;
    }

    public DebtTableView() {
    }

    public DebtTableView(Debt debt) {
        this.debtViewId = debt.getId();
        this.debtViewDate = debt.getRepaymentDate();
        this.debtViewAmount = debt.getDebtAmount();
        this.sumPaymentViewAmount = DebtSummaryData.calculateSumPaymentAmount(debt);
    }


    @Override
    public String toString() {
        return "DebtTableView{" +
                "debtViewId=" + debtViewId +
                ", debtViewDate='" + debtViewDate + '\'' +
                ", debtViewAmount=" + debtViewAmount +
                ", sumPaymentViewAmount=" + sumPaymentViewAmount +
                '}';
    }
}
