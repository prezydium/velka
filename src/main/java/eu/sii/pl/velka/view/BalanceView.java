package eu.sii.pl.velka.view;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.controller.HttpPostTemplate;


import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;




import java.util.List;


@SpringUI
public class BalanceView extends VerticalLayout implements View {

    Debtor debtorResponse = HttpPostTemplate.fetchDataGET();


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){

        addHeader();
        addTable();

    }



    private void addTable() {


        List<Debt> listData= debtorResponse.getDebts();

        Grid<Debt> grid = new Grid();

        grid.setItems(listData);

        grid.addColumn(Debt::getId).setCaption("Id");
        grid.addColumn(Debt::getRepaymentDate).setCaption("Exp Date");
        grid.addColumn(Debt::getDebtValue).setCaption("Value");

        grid.setSizeFull();
        this.addComponentsAndExpand(grid);


    }


    private void addHeader() {
        Label label=new Label();
        label.setValue("First Name: " + debtorResponse.getName() + " Last Name:  " + debtorResponse.getSurname() +" SSN: "+ debtorResponse.getSsn());
        label.addStyleName(ValoTheme.LABEL_H1);
        this.addComponent(label);
    }
}
