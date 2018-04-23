package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class Debt {

    private Long id;

    private BigDecimal debtValue;

    private LocalDate repaymentDate;

    private Debtor debtor;

    private List<Payment> payments;

    public Long getId() {
        return id;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public BigDecimal getDebtValue() {
        return debtValue;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Debt() {
    }

    public Debt(BigDecimal debtValue, LocalDate repaymentDate, List<Payment> payments) {
        this.debtValue = debtValue;
        this.repaymentDate = repaymentDate;
        this.payments = payments;
    }

}