package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.viewModel.DebtTableView;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DebtorSummaryData {

    public static BigDecimal getDebtsSum(Debtor debtor){
        Set<Debt> setDebts= debtor.getDebts();
        return  setDebts.stream().map(Debt::getDebtAmount).reduce(BigDecimal::add).get();

    }

    public static Set<DebtTableView> createDebtorViewSet(Debtor debtor) {
        Set<Debt> debtSet=debtor.getDebts();
        Set<DebtTableView> debtViewSet = new HashSet<>();
        for (Debt debt: debtSet) {
            debtViewSet.add(new DebtTableView(debt));
        }
        return debtViewSet;
    }


    public static BigDecimal getPaymentsSum(Debtor debtor){
        Set<DebtTableView> setDebtsView= createDebtorViewSet(debtor);
        return  setDebtsView.stream().map(DebtTableView::getSumPaymentViewAmount).reduce(BigDecimal::add).get();

    }
}
