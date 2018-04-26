package eu.sii.pl.velka.view;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.FooterRow;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;

import java.util.List;
import java.util.Set;

public class TableLayout extends VerticalLayout {




    public TableLayout(Debtor debtor) {
        DebtorTableView debtorTableView= new DebtorTableView(debtor);
        Grid<DebtTableView> grid= new Grid<>();
     //   Set<Debt> listData= debtor.getDebts();

       // DebtorSummaryData debtorSummaryData=new DebtorSummaryData(listData);
        Set<DebtTableView> debtorViewList =debtorTableView.getDebtViewSet();

        grid.setItems(debtorViewList);
        grid.addColumn(DebtTableView::getDebtViewId).setId("Id").setCaption("Id");
        grid.addColumn(DebtTableView::getDebtViewDate).setId("Repayment Date").setCaption("Repayment Date");
        grid.addColumn(DebtTableView::getDebtViewAmount).setId("Debt Amount").setCaption("Debt Amount");
        grid.addColumn(DebtTableView::getSumPaymentViewAmount).setId("Payment Sum Amount").setCaption("Payment Sum Amount");
//        grid.setItems(listData);
//        grid.addColumn(Debt::getId).setCaption("Id").setId("Id");
//        grid.addColumn(Debt::getRepaymentDate).setCaption("Exp Date");
//        grid.addColumn(Debt::getDebtAmount).setCaption("Debt Amount").setId("Debt Amount");
        //grid.addColumn(debt -> debt.getPayments()).setCaption("Payments").setId("Payments");


       FooterRow footer =grid.prependFooterRow();
      footer.getCell("Id").setText("Total:");
     footer.getCell("Debt Amount").setText(debtorTableView.getDebtsSumView().toString());
     footer.getCell("Payment Sum Amount").setText(debtorTableView.getPaymentsSumView().toString());
        grid.setSizeFull();
        addComponent(grid);

    }


}
