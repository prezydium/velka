package eu.sii.pl.velka.model;

public class PaymentForm {

    private static final String CLIENT_ID="velka";

    private Payment payment;

    private String debtUuid;

    private String snn;

    public static String getClientId() {
        return CLIENT_ID;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getDebtUuid() {
        return debtUuid;
    }

    public void setDebtUuid(String debtUuid) {
        this.debtUuid = debtUuid;
    }

    public String getSnn() {
        return snn;
    }

    public void setSnn(String snn) {
        this.snn = snn;
    }

    public PaymentForm() {
    }

    public PaymentForm(Payment payment, String debtUuid, String snn) {
        this.payment = payment;
        this.debtUuid = debtUuid;
        this.snn = snn;
    }
}
