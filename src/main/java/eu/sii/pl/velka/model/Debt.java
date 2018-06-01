package eu.sii.pl.velka.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


public class Debt {

    private Long id;

    private String debtName;

    private String uuid;

    private BigDecimal debtAmount;
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate repaymentDate;

    private List<Payment> payments = Collections.EMPTY_LIST;

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

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = Collections.unmodifiableList(payments);
    }

    public Debt() {
    }

    public Debt(Long id, String debtName, BigDecimal debtAmount, LocalDate repaymentDate, List<Payment> payments) {
        this.id = id;
        this.debtName = debtName;
        this.debtAmount = debtAmount;
        this.repaymentDate = repaymentDate;
        this.payments = payments;
    }
}
