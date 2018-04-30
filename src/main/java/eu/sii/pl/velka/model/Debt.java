package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Debt {

    private Long id;

    private BigDecimal debtAmount;

    private LocalDate repaymentDate;

    private Debtor debtor;

    private Set<Payment> setOfPayments;

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
        return setOfPayments;
    }

    public void setPayments(Set<Payment> payments) {
        this.setOfPayments = payments;
    }

    public Debt() {
    }

    public Debt(Long id, BigDecimal debtAmount, LocalDate repaymentDate, Set<Payment> setOfPayments) {
        this.id=id;
        this.debtAmount = debtAmount;
        this.repaymentDate = repaymentDate;
        this.setOfPayments = setOfPayments;
           }

}
