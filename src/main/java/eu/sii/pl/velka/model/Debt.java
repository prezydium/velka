package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


public class Debt {

    private Long id;

    private BigDecimal debtAmount;

    private LocalDate repaymentDate;

    private Debtor debtor;

    private Set<Payment> setOfpayments;

    public Long getId() {
        return id;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public Set<Payment> getPayments() {
        return setOfpayments;
    }

    public void setPayments(Set<Payment> payments) {
        this.setOfpayments = payments;
    }

    public Debt() {
    }

    public Debt(Long id, BigDecimal debtAmount, LocalDate repaymentDate, Set<Payment> payments) {
        this.id=id;
        this.debtAmount = debtAmount;
        this.repaymentDate = repaymentDate;
        this.setOfpayments = setOfpayments;
           }

}
