package eu.sii.pl.velka.view;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.FooterRow;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;

import java.util.List;

public class TableLayout extends VerticalLayout {

     Debtor debtor;


    public TableLayout(Debtor debtor) {
        this.debtor = debtor;
        Grid<Debt> grid= new Grid<>();
        List<Debt> listData= debtor.getDebts();

        DebtorSummaryData debtorSummaryData=new DebtorSummaryData(listData);

        grid.setItems(listData);
        grid.addColumn(Debt::getId).setCaption("Id").setId("Id");
        grid.addColumn(Debt::getRepaymentDate).setCaption("Exp Date");
        grid.addColumn(Debt::getDebtValue).setCaption("Amount").setId("Amount");
        //grid.addColumn(debt -> debt.getPayments()).setCaption("Payments").setId("Payments");


        FooterRow footer =grid.prependFooterRow();
        footer.getCell("Id").setText("Total:");
        footer.getCell("Amount").setText(debtorSummaryData.getAmountSum());
        grid.setSizeFull();
        addComponent(grid);

    }


}
