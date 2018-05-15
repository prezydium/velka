package eu.sii.pl.velka.UI.views.components;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.FooterRow;
import eu.sii.pl.velka.UI.viewModel.DebtorTableView;
import eu.sii.pl.velka.UI.viewModel.PaymentPlanTableView;
import eu.sii.pl.velka.UI.viewModel.PlannedPaymentTableView;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;

import java.util.List;

public class TablePannedPayment extends VerticalLayout {

    public TablePannedPayment(Debtor debtor, PaymentPlan paymentPlan) {
        DebtorTableView debtorTableView = new DebtorTableView(debtor);
        PaymentPlanTableView paymentPlanTableView = new PaymentPlanTableView(paymentPlan, debtorTableView);
        Grid<PlannedPaymentTableView> grid = new Grid<>();
        List<PlannedPaymentTableView> plannedPaymentList = paymentPlanTableView.getPlannedPaymentList();
        grid.setItems(plannedPaymentList);
        grid.addColumn(PlannedPaymentTableView::getDebtName).setId("Debt Name").setCaption("Debt Name");
        grid.addColumn(PlannedPaymentTableView::getUuid).setId("Debt uuid").setCaption("Debt uuid");
        grid.addColumn(PlannedPaymentTableView::getExpDate).setId("Repayment Date").setCaption("Repayment Date");
        grid.addColumn(PlannedPaymentTableView::getDebtAmount).setId("Debt Amount").setCaption("Debt Amount");
        grid.addColumn(PlannedPaymentTableView::getSumPaymentAmount).setId("Sum Payment Amount").setCaption("Sum Payment Amount");
        grid.addColumn(PlannedPaymentTableView::getRemainingAmount).setId("Remaining Amount").setCaption("Remaining Amount");
        grid.addColumn(PlannedPaymentTableView::getPlannedRepaymentAmount).setId("Planned Repayment Amount").setCaption("Planned Repayment Amount");
        grid.addColumn(PlannedPaymentTableView::getPlannedRemainingDebtAmount).setId("Planned Remaining Amount").setCaption("Planned Remaining Amount");
        FooterRow footer = grid.prependFooterRow();
        footer.getCell("Debt Name").setText("Total:");
        footer.getCell("Debt Amount").setText(debtorTableView.getDebtsSumView().toString());
        footer.getCell("Sum Payment Amount").setText(debtorTableView.getPaymentAmountSumView().toString());
        footer.getCell("Remaining Amount").setText(debtorTableView.getRemainingAmountSumView().toString());
        footer.getCell("Planned Repayment Amount").setText(paymentPlanTableView.getSumOfPlannedRepaymentAmount().toString());
        footer.getCell("Planned Remaining Amount").setText(paymentPlanTableView.getSumOfPlannedRemaingAmount().toString());
        grid.setSizeFull();
        addComponent(grid);
    }
}