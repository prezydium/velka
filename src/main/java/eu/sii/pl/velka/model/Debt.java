package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


public class Debt {

    private Long id;

    private BigDecimal debtAmount;

    private LocalDate repaymentDate;

    private Set<Payment> listOfPayments;

    public Long getId() {
        return id;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public Set<Payment> getPayments() {
        return listOfPayments;
    }

    public void setPayments(Set<Payment> payments) {
        this.listOfPayments = payments;
    }

    public Debt() {
    }

    public Debt(Long id, BigDecimal debtAmount, LocalDate repaymentDate, Set<Payment> listOfPayments) {
        this.id=id;
        this.debtAmount = debtAmount;
        this.repaymentDate = repaymentDate;
        this.listOfPayments = listOfPayments;
           }

}
