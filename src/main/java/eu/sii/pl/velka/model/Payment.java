package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Payment {

    private Long id;

    private LocalDate paymentDate;

    private BigDecimal paymentAmount;

    private CreditCard creditCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Payment() {
    }

    public Payment(Long id, LocalDate paymentDate, BigDecimal paymentAmount, CreditCard creditCard) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.creditCard = creditCard;
    }
}
