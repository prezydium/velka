package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Payment {

    private Long id;

    private LocalDate date;

    private BigDecimal value;

    private CreditCard creditCard;

    private Debt debt;

    public Long getId() {
        return id;
    }

    public Debt getDebt() {
        return debt;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Payment() {
    }

    public Payment(LocalDate date, BigDecimal value, CreditCard creditCard) {
        this.date = date;
        this.value = value;
        this.creditCard = creditCard;
    }
}
