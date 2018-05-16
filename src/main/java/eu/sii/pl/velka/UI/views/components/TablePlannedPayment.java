package eu.sii.pl.velka.UI.views.components;

import com.vaadin.ui.Grid;
import com.vaadin.ui.components.grid.FooterRow;
import eu.sii.pl.velka.UI.viewModel.DebtorTableView;
import eu.sii.pl.velka.UI.viewModel.PaymentPlanTableView;
import eu.sii.pl.velka.UI.viewModel.PlannedPaymentTableView;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;

import java.util.List;

public class TablePlannedPayment extends AbstractTableLayout<PaymentPlanTableView> {

    public TablePlannedPayment(Debtor debtor, PaymentPlan paymentPlan) {
        DebtorTableView debtorTableView = new DebtorTableView(debtor);
        PaymentPlanTableView paymentPlanTableView = new PaymentPlanTableView(paymentPlan, debtorTableView);
        Grid<PlannedPaymentTableView> grid = setGridColumns(paymentPlanTableView);
        createFooter(grid,paymentPlanTableView);
        grid.setSizeFull();
        addComponent(grid);
    }

    @Override
    public Grid setGridColumns(PaymentPlanTableView paymentPlanTableView) {
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
        return grid;
    }

    @Override
    public void createFooter(Grid grid, PaymentPlanTableView paymentPlanTableView) {
        FooterRow footer = grid.prependFooterRow();
        footer.getCell("Debt Name").setText("Total:");
        footer.getCell("Debt Amount").setText(paymentPlanTableView.getSumOfDebtsAmount().toString());
        footer.getCell("Sum Payment Amount").setText(paymentPlanTableView.getSumOfPaymentAmount().toString());
        footer.getCell("Remaining Amount").setText(paymentPlanTableView.getSumOfRemainingAmount().toString());
        footer.getCell("Planned Repayment Amount").setText(paymentPlanTableView.getSumOfPlannedRepaymentAmount().toString());
        footer.getCell("Planned Remaining Amount").setText(paymentPlanTableView.getSumOfPlannedRemainingAmount().toString());
    }
}