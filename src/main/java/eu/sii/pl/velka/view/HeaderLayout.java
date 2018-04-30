package eu.sii.pl.velka.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.viewModel.DebtorTableView;

public class HeaderLayout extends VerticalLayout {

    public HeaderLayout(Debtor debtor) {
        DebtorTableView debtorTableView= new DebtorTableView(debtor);
        Label label=new Label();
        Label label1=new Label();
        Label label2=new Label();
        label.setValue("First Name: " + debtorTableView.getFirstName());
        label1.setValue("Last Name:  " + debtorTableView.getLastName());
        label2.setValue("SSN: "+ debtorTableView.getSsn());
        label.addStyleName(ValoTheme.LABEL_SMALL);
        label1.addStyleName(ValoTheme.LABEL_SMALL);
        label2.addStyleName(ValoTheme.LABEL_SMALL);
        addComponent(label);
        addComponent(label1);
        addComponent(label2);
    }
}
