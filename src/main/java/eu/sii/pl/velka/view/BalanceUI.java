package eu.sii.pl.velka.view;


import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.controller.HttpPostTemplate;


import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;




import java.util.List;


@SpringUI
public class BalanceUI  extends UI {

    private VerticalLayout root;
    Debtor debtorResponse = HttpPostTemplate.fetchDataGET();


    @Override
    protected void init(VaadinRequest vaadinRequest){

        setupLayout();
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
        root.addComponentsAndExpand(grid);


    }



    private void setupLayout() {
        root= new VerticalLayout();
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }
    private void addHeader() {
        Label label=new Label("Balance");
        label.setValue("Debtor: " + "First Name: " + debtorResponse.getName() + "Last Name:  " + debtorResponse.getSurname() +"SSN: "+ debtorResponse.getSsn());
        label.addStyleName(ValoTheme.LABEL_H1);
        root.addComponent(label);
    }
}
