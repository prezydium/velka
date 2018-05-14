package eu.sii.pl.velka.utils;

import com.sun.xml.internal.bind.v2.TODO;
import eu.sii.pl.velka.UI.viewModel.DebtorTableView;
import eu.sii.pl.velka.UI.viewModel.PlannedPaymentTableView;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.UI.viewModel.DebtTableView;
import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.model.PlannedPayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

// TODO make final, private constructor
public class DebtorSummaryData {

    public static BigDecimal getDebtsSum(Debtor debtor) {
        List<Debt> listOfDebts = debtor.getListOfDebts();
        return listOfDebts.stream().map(Debt::getDebtAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
    }
    public static BigDecimal getPaymentPlanRepaymentSum(PaymentPlan paymentPlan) {
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
        for (PlannedPayment plannedPayment : listOfPlannedPayment) {
            DebtTableView debtTableView = debtorTableView.getDebtViewSet().stream()
                    .filter(d -> plannedPayment.getUuid().equals(d.getUuid())).findFirst().orElse(new DebtTableView());
            planedViewSet.add(new PlannedPaymentTableView(plannedPayment, debtTableView));
        }
        return planedViewSet;
    } // TODO change to generic method, test

    public static BigDecimal getRemainingAmountSum(Debtor debtor) {
        Set<DebtTableView> setDebtsView = createDebtorViewSet(debtor);
        return setDebtsView.stream().map(DebtTableView::getRemainingAmountView).reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
