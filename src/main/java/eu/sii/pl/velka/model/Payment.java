package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Payment {

    private Long id;

    private String paymentDate;

    private BigDecimal paymentAmount;

    private CreditCard creditCard;

    private Debt debt;

    public Long getId() {
        return id;
    }

    public Debt getDebt() {
        return debt;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getValue() {
        return paymentAmount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Payment() {
    }

    public Payment(Long id, String paymentDate, BigDecimal paymentAmount, CreditCard creditCard, Debt debt) {
        this.id=id;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.creditCard = creditCard;
        this.debt=debt;
    }
}
