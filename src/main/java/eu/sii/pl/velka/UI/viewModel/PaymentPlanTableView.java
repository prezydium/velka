package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.utils.DebtorSummaryData;

import java.util.List;

public class PaymentPlanTableView {
    private String message;
    private String ssn;
    private List<PlannedPaymentTableView> plannedPaymentList;

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

    public PaymentPlanTableView() {
    }

    public PaymentPlanTableView(PaymentPlan paymentPlan, DebtorTableView debtorTableView) {
        this.message = paymentPlan.getMessage();
        this.ssn = paymentPlan.getSsn();
        this.plannedPaymentList =  DebtorSummaryData.createPaymentPlanViewSet(paymentPlan, debtorTableView);
    }
}
