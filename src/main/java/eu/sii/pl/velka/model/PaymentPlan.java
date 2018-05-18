package eu.sii.pl.velka.model;

import java.util.List;

public class PaymentPlan {

    private String message;
    private String ssn;
    private List<PlannedPayment> plannedPaymentList;

    public PaymentPlan() {
    }

    public PaymentPlan(String message, String ssn, List<PlannedPayment> plannedPaymentList) {
        this.message = message;
        this.ssn = ssn;
        this.plannedPaymentList = plannedPaymentList;
    }

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

    public List<PlannedPayment> getPlannedPaymentList() {
        return plannedPaymentList;
    }

    public void setPlannedPaymentList(List<PlannedPayment> plannedPaymentList) {
        this.plannedPaymentList = plannedPaymentList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentPlan{");
        sb.append("message='").append(message).append('\'');
        sb.append(", ssn='").append(ssn).append('\'');
        sb.append(", plannedPaymentList=").append(plannedPaymentList);
        sb.append('}');
        return sb.toString();
    }
}
