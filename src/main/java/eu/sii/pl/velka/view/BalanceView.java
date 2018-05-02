package eu.sii.pl.velka.view;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.sii.pl.velka.controller.BalanceController;
import eu.sii.pl.velka.model.Debtor;

@SpringView(name = "balance")
public class BalanceView extends VerticalLayout implements View {

    TableLayout tableLayout;
    HeaderLayout headerLayout;
    BalanceController balanceController;

    public BalanceView() {
        this.balanceController = new BalanceController();
        Debtor debtor = balanceController.getDebtorBalance("980-122-111");
        this.tableLayout = new TableLayout(debtor);
        this.headerLayout = new HeaderLayout(debtor);
        addHeader(this.headerLayout);
        addTable(this.tableLayout);
    }

    private void addTable(TableLayout tableLayout) {
        this.addComponent(tableLayout);
    }

    private void addHeader(HeaderLayout headerLayout) {
        this.addComponent(headerLayout);
    }
}
