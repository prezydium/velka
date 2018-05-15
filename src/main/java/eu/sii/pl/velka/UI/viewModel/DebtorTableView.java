package eu.sii.pl.velka.UI.viewModel;

import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.utils.DebtorSummaryDataUtil;

import java.math.BigDecimal;
import java.util.Set;

public class DebtorTableView {
    private String firstName;
    private String lastName;
    private String ssn;
    private Set<DebtTableView> debtViewSet;
    private BigDecimal paymentAmountSumView;
    private BigDecimal remainingAmountSumView;
    private BigDecimal debtsSumView;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Set<DebtTableView> getDebtViewSet() {
        return debtViewSet;
    }

    public void setDebtViewSet(Set<DebtTableView> debtViewSet) {
        this.debtViewSet = debtViewSet;
    }

    public BigDecimal getPaymentAmountSumView() {
        return paymentAmountSumView;
    }

    public void setPaymentAmountSumView(BigDecimal paymentAmountSumView) {
        this.paymentAmountSumView = paymentAmountSumView;
    }

    public BigDecimal getRemainingAmountSumView() {
        return remainingAmountSumView;
    }

    public void setRemainingAmountSumView(BigDecimal remainingAmountSumView) {
        this.remainingAmountSumView = remainingAmountSumView;
    }

    public BigDecimal getDebtsSumView() {
        return debtsSumView;
    }

    public void setDebtsSumView(BigDecimal debtsSumView) {
        this.debtsSumView = debtsSumView;
    }

    public DebtorTableView(Debtor debtor) {
        this.firstName = debtor.getFirstName();
        this.lastName = debtor.getLastName();
        this.ssn = debtor.getSsn();
        this.debtViewSet = DebtorSummaryDataUtil.createDebtorViewSet(debtor);
        this.debtsSumView = DebtorSummaryDataUtil.getDebtsSum(debtor);
        this.remainingAmountSumView = DebtorSummaryDataUtil.getRemainingAmountSum(debtor);
        this.paymentAmountSumView = DebtorSummaryDataUtil.getDebtsSum(debtor).subtract(DebtorSummaryDataUtil.getRemainingAmountSum(debtor));
    }
}
