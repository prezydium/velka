package eu.sii.pl.velka.UI.views;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.Payment;

@SpringView(name = "balance")
public class BalanceView extends VerticalLayout implements View {

    TableLayout tableLayout;
    HeaderLayout headerLayout;
    PaymentForm paymentForm;


    public BalanceView() {
        Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
        this.tableLayout = new TableLayout(debtor);
        this.headerLayout = new HeaderLayout(debtor);
        this.paymentForm = new PaymentForm();
        addHeader(this.headerLayout);
        addTable(this.tableLayout);
        this.addComponent(this.paymentForm);
    }


    private void addTable(TableLayout tableLayout) {
        this.addComponent(tableLayout);
    }

    private void addHeader(HeaderLayout headerLayout) {
        this.addComponent(headerLayout);
    }
}
