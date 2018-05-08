package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Payment;
import eu.sii.pl.velka.model.PaymentForm;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentFormView {

    private String debtUuid;
    private String ssn;
    private BigDecimal paymentAmount;
    private String ccNumber;
    private String cvv;
    private String issuingNetwork;
    private String firstName;
    private String lastName;
    private LocalDate expDate;

    public String getDebtUuid() {
        return debtUuid;
    }

    public void setDebtUuid(String debtUuid) {
        this.debtUuid = debtUuid;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public  BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public  void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getIssuingNetwork() {
        return issuingNetwork;
    }

    public void setIssuingNetwork(String issuingNetwork) {
        this.issuingNetwork = issuingNetwork;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public PaymentFormView() {
    }

    public PaymentFormView(String debtUuid, String ssn, BigDecimal paymentAmount, String ccNumber, String cvv, String issuingNetwork, String firstName, String lastName, LocalDate expDate) {
        this.debtUuid = debtUuid;
        this.ssn = ssn;
        this.paymentAmount = paymentAmount;
        this.ccNumber = ccNumber;
        this.cvv = cvv;
        this.issuingNetwork = issuingNetwork;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "PaymentFormView{" +
                "debtUuid='" + debtUuid + '\'' +
                ", ssn='" + ssn + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", ccNumber='" + ccNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", issuingNetwork='" + issuingNetwork + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", expDate=" + expDate +
                '}';
    }
    public PaymentForm maptoPaymentForm(){
        CreditCard creditCard=new CreditCard();
        creditCard.setCcNumber(this.ccNumber);
        creditCard.setCvv(this.cvv);
        creditCard.setExpDate(this.expDate);
        creditCard.setFirstName(this.firstName);
        creditCard.setLastName(this.lastName);
        creditCard.setIssuingNetwork(this.issuingNetwork);
        Payment payment=new Payment();
        payment.setCreditCard(creditCard);
        payment.setPaymentAmount(this.paymentAmount);
        return new PaymentForm(payment,this.debtUuid,this.ssn);
    }
}
