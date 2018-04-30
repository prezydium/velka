package eu.sii.pl.velka.view;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.FooterRow;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.viewModel.DebtTableView;
import eu.sii.pl.velka.view.viewModel.DebtorTableView;

import java.util.Set;

public class TableLayout extends VerticalLayout {




    public TableLayout(Debtor debtor) {
        DebtorTableView debtorTableView= new DebtorTableView(debtor);
        Grid<DebtTableView> grid= new Grid<>();

        Set<DebtTableView> debtorViewList =debtorTableView.getDebtViewSet();

        grid.setItems(debtorViewList);
        grid.addColumn(DebtTableView::getDebtViewId).setId("Id").setCaption("Id");
        grid.addColumn(DebtTableView::getDebtViewDate).setId("Repayment Date").setCaption("Repayment Date");
        grid.addColumn(DebtTableView::getDebtViewAmount).setId("Debt Amount").setCaption("Debt Amount");
        grid.addColumn(DebtTableView::getRemainingAmountView).setId("Remaining Amount").setCaption("Remaining Amount");


        FooterRow footer = grid.prependFooterRow();
        footer.getCell("Id").setText("Total:");
        footer.getCell("Debt Amount").setText(debtorTableView.getDebtsSumView().toString());
        footer.getCell("Remaining Amount").setText(debtorTableView.getRemainingAmountSumView().toString());
        grid.setSizeFull();
        addComponent(grid);

    }


}
