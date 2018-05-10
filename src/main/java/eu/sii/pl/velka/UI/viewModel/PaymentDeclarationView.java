package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.PaymentDeclaration;

import java.math.BigDecimal;

public class PaymentDeclarationView {

    private static final String CLIENT_ID = "velka";

    private String amount;

    private String debtUuid;

    private String ssn;

    public static String getClientId() {
        return CLIENT_ID;
    }

    public String getDebtUuid() {
        return debtUuid;
    }

    public void setDebtUuid(String debtUuid) {
        this.debtUuid = debtUuid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public PaymentDeclarationView() {
    }

    public PaymentDeclarationView(String amount, String debtUuid, String ssn) {
        this.amount = amount;
        this.debtUuid = debtUuid;
        this.ssn = ssn;
    }
    public PaymentDeclaration mapToPaymentDeclaration(){

        return new PaymentDeclaration(new BigDecimal(amount),this.debtUuid,this.ssn);
    }
}
