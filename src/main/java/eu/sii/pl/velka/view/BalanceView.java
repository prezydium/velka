package eu.sii.pl.velka.view;


import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import eu.sii.pl.velka.model.Debtor;







public class BalanceView extends VerticalLayout implements View {


    TableLayout tableLayout;
    HeaderLayout headerLayout;

    public BalanceView(Debtor debtor){

    this.tableLayout=new TableLayout(debtor);
    this.headerLayout=new HeaderLayout(debtor);
    addHeader(this.headerLayout);
    addTable(this.tableLayout);
    }



    private void addTable(TableLayout tableLayout) {
        this.addComponent( tableLayout);
    }


    private void addHeader(HeaderLayout headerLayout) {
      this.addComponent(headerLayout);
    }
}
