package eu.sii.pl.velka.view;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.controller.HttpPostTemplate;
import eu.sii.pl.velka.model.Debtor;







public class BalanceView extends VerticalLayout implements View {

    Debtor debtorResponse = HttpPostTemplate.fetchDataGET();
    TableLayout tableLayout=new TableLayout(debtorResponse);

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        addHeader();
        addTable();
    }



    private void addTable() {
        this.addComponent( tableLayout);
    }


    private void addHeader() {
        Label label=new Label();
        Label label1=new Label();
        Label label2=new Label();
        label.setValue("First Name: " + debtorResponse.getName());
        label1.setValue("Last Name:  " + debtorResponse.getSurname());
        label2.setValue("SSN: "+ debtorResponse.getSsn());
        label.addStyleName(ValoTheme.LABEL_H1);
        this.addComponent(label);
        this.addComponent(label1);
        this.addComponent(label2);
    }
}
