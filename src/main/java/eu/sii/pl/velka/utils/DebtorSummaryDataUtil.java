package eu.sii.pl.velka.utils;

import eu.sii.pl.velka.ui.viewModel.DebtTableView;
import eu.sii.pl.velka.ui.viewModel.DebtorTableView;
import eu.sii.pl.velka.ui.viewModel.PlannedPaymentTableView;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.model.PlannedPayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public final class DebtorSummaryDataUtil {

    private DebtorSummaryDataUtil() {
    }

    public static BigDecimal getDebtsSum(Debtor debtor) {
        List<Debt> listOfDebts = debtor.getListOfDebts();
        return listOfDebts.stream().map(Debt::getDebtAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal getPlanRepaymentSum(PaymentPlan paymentPlan) {
        List<PlannedPayment> listOfPlannedPayment = paymentPlan.getPlannedPaymentList();
        return listOfPlannedPayment.stream().map(PlannedPayment::getAmountOfRepaymentDebt)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static Set<DebtTableView> createDebtorViewSet(Debtor debtor) {
        List<Debt> listOfDebts = debtor.getListOfDebts();
        Set<DebtTableView> debtViewSet = new HashSet<>();
        for (Debt debt : listOfDebts) {
            debtViewSet.add(new DebtTableView(debt));
        }
        return debtViewSet;
    }

    public static List<PlannedPaymentTableView> createPaymentPlanViewSet(PaymentPlan paymentPlan, DebtorTableView debtorTableView) {
        List<PlannedPayment> listOfPlannedPayment = paymentPlan.getPlannedPaymentList();
        List<PlannedPaymentTableView> planedViewSet = new ArrayList<>();
        for (DebtTableView debt: debtorTableView.getDebtViewSet()) {
            PlannedPayment plannedPayment = listOfPlannedPayment.stream()
                  .filter(d -> debt.getUuid().equals(d.getUuid())).findFirst().orElse(new PlannedPayment("",new BigDecimal(0)));
            PlannedPaymentTableView plannedPaymentTableView=new PlannedPaymentTableView(plannedPayment, debt);
            planedViewSet.add(plannedPaymentTableView);
        }
        return planedViewSet;
    }

    public static BigDecimal getRemainingAmountSum(Debtor debtor) {
        Set<DebtTableView> setDebtsView = createDebtorViewSet(debtor);
        return setDebtsView.stream().map(DebtTableView::getRemainingAmountView).reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}