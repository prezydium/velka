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
    private BigDecimal sumOfPaymentAmount;
    private BigDecimal sumOfPlannedRepaymentAmount;
    private BigDecimal sumOfPlannedRemainingAmount;

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

    public BigDecimal getSumOfPaymentAmount() {
        return sumOfPaymentAmount;
    }

    public void setSumOfPaymentAmount(BigDecimal sumOfPaymentAmount) {
        this.sumOfPaymentAmount = sumOfPaymentAmount;
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

    public BigDecimal getSumOfPlannedRemainingAmount() {
        return sumOfPlannedRemainingAmount;
    }

    public void setSumOfPlannedRemainingAmount(BigDecimal sumOfPlannedRemainingAmount) {
        this.sumOfPlannedRemainingAmount = sumOfPlannedRemainingAmount;
    }

    public PaymentPlanTableView() {
    }

    public PaymentPlanTableView(PaymentPlan paymentPlan, DebtorTableView debtorTableView) {
        this.message = paymentPlan.getMessage();
        this.ssn = paymentPlan.getSsn();
        this.sumOfDebtsAmount = debtorTableView.getDebtsSumView();
        this.sumOfPlannedRepaymentAmount = DebtorSummaryDataUtil.getPlanRepaymentSum(paymentPlan);
        this.sumOfPlannedRemainingAmount = debtorTableView.getDebtsSumView().subtract(DebtorSummaryDataUtil.getPlanRepaymentSum(paymentPlan))
                .subtract(debtorTableView.getPaymentAmountSumView());
        this.sumOfPaymentAmount = debtorTableView.getPaymentAmountSumView();
        this.sumOfRemainingAmount = debtorTableView.getRemainingAmountSumView();
        this.plannedPaymentList = DebtorSummaryDataUtil.createPaymentPlanViewSet(paymentPlan, debtorTableView);
    }
}
