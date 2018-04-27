package eu.sii.pl.velka.view.viewModel;

import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.utils.DebtorSummaryData;

import java.math.BigDecimal;
import java.util.Set;

public class DebtorTableView {
    Set<DebtTableView>  debtViewSet;
    BigDecimal paymentsSumView;
    BigDecimal debtsSumView;


    public Set<DebtTableView> getDebtViewSet() {
        return debtViewSet;
    }

    public BigDecimal getPaymentsSumView() {
        return paymentsSumView;
    }

    public BigDecimal getDebtsSumView() {
        return debtsSumView;
    }

    public DebtorTableView(Debtor debtor) {
        this.debtViewSet = DebtorSummaryData.createDebtorViewSet(debtor);
        this.paymentsSumView = DebtorSummaryData.getPaymentsSum(debtor);
        this.debtsSumView = DebtorSummaryData.getDebtsSum(debtor);
    }

}
