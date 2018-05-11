package eu.sii.pl.velka.model;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import java.math.BigDecimal;


@SpringComponent
@UIScope
public class PaymentDeclaration {

    private static final String CLIENT_ID = "velka";

    private BigDecimal paymentAmount;

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

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public PaymentDeclaration() {
    }

    public PaymentDeclaration(BigDecimal paymentAmount, String debtUuid, String ssn) {
        this.paymentAmount = paymentAmount;
        this.debtUuid = debtUuid;
        this.ssn = ssn;
    }

}
