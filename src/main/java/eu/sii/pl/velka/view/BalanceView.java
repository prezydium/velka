package eu.sii.pl.velka.view;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.paymentWindow.PaymentMethodWindow;

@SpringView(name = BalanceView.VIEW_NAME)
public class BalanceView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "balance";

    private TableLayout tableLayout;
    private HeaderLayout headerLayout;

    public BalanceView() {
        Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
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
