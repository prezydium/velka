package eu.sii.pl.velka.view.viewModel;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.viewModel.DebtTableView;

import java.math.BigDecimal;
import java.util.HashSet;
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
        this.debtViewSet = createDebtorViewSet(debtor);
        this.paymentsSumView = calculatePaymentsSum(debtor);
        this.debtsSumView = calculateDebtsSum(debtor);
    }

    private Set<DebtTableView> createDebtorViewSet(Debtor debtor) {
        Set<Debt> debtSet=debtor.getDebts();
        Set<DebtTableView> debtViewSet = new HashSet<>();
        for (Debt debt: debtSet) {
            debtViewSet.add(new DebtTableView(debt));
        }
        return debtViewSet;
    }
    private BigDecimal calculateDebtsSum(Debtor debtor){
        Set<Debt> setDebts= debtor.getDebts();
        return  setDebts.stream().map(Debt::getDebtAmount).reduce(BigDecimal::add).get();

    }  private BigDecimal calculatePaymentsSum(Debtor debtor){
        Set<DebtTableView> setDebtsView= createDebtorViewSet(debtor);
        return  setDebtsView.stream().map(DebtTableView::getSumPaymentViewAmount).reduce(BigDecimal::add).get();

    }
}
