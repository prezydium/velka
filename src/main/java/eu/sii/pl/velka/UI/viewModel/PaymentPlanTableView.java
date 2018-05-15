package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.utils.DebtorSummaryDataUtil;

import java.math.BigDecimal;
import java.util.List;

public class PaymentPlanTableView {
    private String message;
    private String ssn;
    private List<PlannedPaymentTableView> plannedPaymentList;
    private BigDecimal sumOfDebtsAmount;
    private BigDecimal sumOfRemainingAmount;
    private BigDecimal sumOfPlannedRepaymentAmount;
    private BigDecimal sumOfPlannedRemaingAmount;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<PlannedPaymentTableView> getPlannedPaymentList() {
        return plannedPaymentList;
    }

    public void setPlannedPaymentList(List<PlannedPaymentTableView> plannedPaymentList) {
        this.plannedPaymentList = plannedPaymentList;
    }

    public BigDecimal getSumOfDebtsAmount() {
        return sumOfDebtsAmount;
    }

    public void setSumOfDebtsAmount(BigDecimal sumOfDebtsAmount) {
        this.sumOfDebtsAmount = sumOfDebtsAmount;
    }

    public BigDecimal getSumOfRemainingAmount() {
        return sumOfRemainingAmount;
    }

    public void setSumOfRemainingAmount(BigDecimal sumOfRemainingAmount) {
        this.sumOfRemainingAmount = sumOfRemainingAmount;
    }

    public BigDecimal getSumOfPlannedRepaymentAmount() {
        return sumOfPlannedRepaymentAmount;
    }

    public void setSumOfPlannedRepaymentAmount(BigDecimal sumOfPlannedRepaymentAmount) {
        this.sumOfPlannedRepaymentAmount = sumOfPlannedRepaymentAmount;
    }

    public BigDecimal getSumOfPlannedRemaingAmount() {
        return sumOfPlannedRemaingAmount;
    }

    public void setSumOfPlannedRemaingAmount(BigDecimal sumOfPlannedRemaingAmount) {
        this.sumOfPlannedRemaingAmount = sumOfPlannedRemaingAmount;
    }

    public PaymentPlanTableView() {
    }

    public PaymentPlanTableView(PaymentPlan paymentPlan, DebtorTableView debtorTableView) {
        this.message = paymentPlan.getMessage();
        this.ssn = paymentPlan.getSsn();
        this.sumOfPlannedRepaymentAmount=DebtorSummaryDataUtil.getPlanRepaymentSum(paymentPlan);
        this.sumOfPlannedRemaingAmount=debtorTableView.getDebtsSumView().subtract(DebtorSummaryDataUtil.getPlanRepaymentSum(paymentPlan));
        this.plannedPaymentList =  DebtorSummaryDataUtil.createPaymentPlanViewSet(paymentPlan, debtorTableView);
    }
}
