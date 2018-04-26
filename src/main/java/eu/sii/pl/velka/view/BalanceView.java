package eu.sii.pl.velka.view;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.controller.HttpPostTemplate;
import eu.sii.pl.velka.model.Debtor;







public class BalanceView extends VerticalLayout implements View {

    Debtor debtorResponse = HttpPostTemplate.fetchDataGET();
    TableLayout tableLayout=new TableLayout(debtorResponse);
    HeaderLayout headerLayout=new HeaderLayout(debtorResponse);

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        addHeader();
        addTable();
    }



    private void addTable() {
        this.addComponent( tableLayout);
    }


    private void addHeader() {
      this.addComponent(headerLayout);
    }
}
