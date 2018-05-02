package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class Debt {

    private Long id;

    private BigDecimal debtAmount;

    private LocalDate repaymentDate;

    private List<Payment> listOfPayments;

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

    public List<Payment> getListOfPayments() {
        return listOfPayments;
    }

    public void setListOfPayments(List<Payment> listOfPayments) {
        this.listOfPayments = Collections.unmodifiableList(listOfPayments);
    }

    public Debt() {
    }

    public Debt(Long id, BigDecimal debtAmount, LocalDate repaymentDate, List<Payment> listOfPayments) {
        this.id=id;
        this.debtAmount = debtAmount;
        this.repaymentDate = repaymentDate;
        this.listOfPayments = listOfPayments;
           }

}
