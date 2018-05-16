package eu.sii.pl.velka.ui.views.components;

import com.vaadin.ui.Grid;
import com.vaadin.ui.components.grid.FooterRow;
import eu.sii.pl.velka.ui.viewModel.DebtTableView;
import eu.sii.pl.velka.ui.viewModel.DebtorTableView;
import eu.sii.pl.velka.model.Debtor;

import java.util.Set;

public class TableBalanceLayout extends AbstractTableLayout<DebtorTableView> {

    public TableBalanceLayout(Debtor debtor) {
        DebtorTableView debtorTableView = new DebtorTableView(debtor);
        Grid grid = setGridColumns(debtorTableView);
        createFooter(grid, debtorTableView);
        grid.setSizeFull();
        addComponent(grid);
    }

    @Override
    public Grid setGridColumns(DebtorTableView debtorTableView) {
        Grid<DebtTableView> grid = new Grid<>();
        Set<DebtTableView> debtorViewList = debtorTableView.getDebtViewSet();
        grid.setItems(debtorViewList);
        grid.addColumn(DebtTableView::getDebtViewName).setId("Debt Name").setCaption("Debt Name");
        grid.addColumn(DebtTableView::getUuid).setId("Debt uuid").setCaption("Debt uuid");
        grid.addColumn(DebtTableView::getDebtViewDate).setId("Repayment Date").setCaption("Repayment Date");
        grid.addColumn(DebtTableView::getDebtViewAmount).setId("Debt Amount").setCaption("Debt Amount");
        grid.addColumn(DebtTableView::getSumPaymentViewAmount).setId("Debt Sum Payment").setCaption("Debt Sum Payment Amount");
        grid.addColumn(DebtTableView::getRemainingAmountView).setId("Remaining Amount").setCaption("Remaining Amount");
        return grid;
    }


    public void createFooter(Grid grid, DebtorTableView debtorTableView) {
        FooterRow footer = grid.prependFooterRow();
        footer.getCell("Debt Name").setText("Total:");
        footer.getCell("Debt Amount").setText(debtorTableView.getDebtsSumView().toString());
        footer.getCell("Debt Sum Payment").setText(debtorTableView.getPaymentAmountSumView().toString());
        footer.getCell("Remaining Amount").setText(debtorTableView.getRemainingAmountSumView().toString());
    }
}
