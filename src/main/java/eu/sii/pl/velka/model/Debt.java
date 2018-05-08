package eu.sii.pl.velka.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class Debt {

    private Long id;

    private String debtName;

    private String  uuid;

    private BigDecimal debtAmount;

    private LocalDate repaymentDate;

    private List<Payment> listOfPayments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDebtName() {
        return debtName;
    }

    public void setDebtName(String debtName) {
        this.debtName = debtName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Debt(Long id, String debtName, BigDecimal debtAmount, LocalDate repaymentDate, List<Payment> listOfPayments) {
        this.id = id;
        this.debtName=debtName;
        this.debtAmount = debtAmount;
        this.repaymentDate = repaymentDate;
        this.listOfPayments = listOfPayments;
    }
}
