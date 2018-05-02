package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.viewModel.DebtTableView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DebtorSummaryData {

    public static BigDecimal getDebtsSum(Debtor debtor) {
        List<Debt> setDebts = debtor.getListOfDebts();
        return setDebts.stream().map(Debt::getDebtAmount).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);

    }

    public static Set<DebtTableView> createDebtorViewSet(Debtor debtor) {
        List<Debt> debtSet = debtor.getListOfDebts();
        Set<DebtTableView> debtViewSet = new HashSet<>();
        for (Debt debt : debtSet) {
            debtViewSet.add(new DebtTableView(debt));
        }
        return debtViewSet;
    }


    public static BigDecimal getRemainingAmountSum(Debtor debtor) {
        Set<DebtTableView> setDebtsView = createDebtorViewSet(debtor);
        return setDebtsView.stream().map(DebtTableView::getRemainingAmountView).reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);

    }
}
