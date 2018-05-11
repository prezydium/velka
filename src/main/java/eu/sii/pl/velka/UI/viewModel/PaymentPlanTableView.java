package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.utils.DebtorSummaryData;

import java.util.List;

public class PaymentPlanTableView {
    private String message;
    private String ssn;
    private List<PlannedPaymentTableView> plannedPaymentList;

    public PaymentPlanTableView() {
    }

    public PaymentPlanTableView(PaymentPlan paymentPlan) {
        this.message = paymentPlan.getMessage();
        this.ssn = paymentPlan.getSsn();
        this.plannedPaymentList =  DebtorSummaryData.createPaymentPlanViewSet(paymentPlan);
    }
}
