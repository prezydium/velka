package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Debt {

    private Long id;

    private BigDecimal debtAmount;

    private LocalDate repaymentDate;

    private List<Payment> payments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(BigDecimal debtAmount) {
        this.debtAmount = debtAmount;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(LocalDate repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Debt() {
    }

    public Debt(BigDecimal debtAmount, LocalDate repaymentDate, List<Payment> payments) {
        this.debtAmount = debtAmount;
        this.repaymentDate = repaymentDate;
        this.payments = new ArrayList<>(payments);
    }

}
