package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Payment {

    private Long id;

    private LocalDate paymentDate;

    private BigDecimal paymentAmount;

    private CreditCard creditCard;

    private Debt debt;

    public Long getId() {
        return id;
    }

    public Debt getDebt() {
        return debt;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getValue() {
        return paymentAmount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }



    public Payment(Long id, LocalDate paymentDate, BigDecimal paymentAmount, CreditCard creditCard, Debt debt) {
        this.id=id;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.creditCard = creditCard;
        this.debt=debt;
    }
}
