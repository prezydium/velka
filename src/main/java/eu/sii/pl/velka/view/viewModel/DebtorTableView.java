package eu.sii.pl.velka.view.viewModel;

import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.utils.DebtorSummaryData;

import java.math.BigDecimal;
import java.util.Set;

public class DebtorTableView {
    private String firstName;
    private String lastName;
    private String ssn;
    private Set<DebtTableView> debtViewSet;
    private BigDecimal RemainingAmountSumView;
    private BigDecimal debtsSumView;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public Set<DebtTableView> getDebtViewSet() {
        return debtViewSet;
    }

    public BigDecimal getRemainingAmountSumView() {
        return RemainingAmountSumView;
    }

    public BigDecimal getDebtsSumView() {
        return debtsSumView;
    }

    public DebtorTableView(Debtor debtor) {
        this.firstName = debtor.getFirstName();
        this.lastName = debtor.getLastName();
        this.ssn = debtor.getSsn();
        this.debtViewSet = DebtorSummaryData.createDebtorViewSet(debtor);
        this.RemainingAmountSumView = DebtorSummaryData.getRemainingAmountSum(debtor);
        this.debtsSumView = DebtorSummaryData.getDebtsSum(debtor);
    }
}
