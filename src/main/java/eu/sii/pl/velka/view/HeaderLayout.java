package eu.sii.pl.velka.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.model.Debtor;

public class HeaderLayout extends VerticalLayout {

    public HeaderLayout(Debtor debtor) {
        Label label=new Label();
        Label label1=new Label();
        Label label2=new Label();
        label.setValue("First Name: " + debtor.getFirstName());
        label1.setValue("Last Name:  " + debtor.getLastName());
        label2.setValue("SSN: "+ debtor.getSsn());
        label.addStyleName(ValoTheme.LABEL_SMALL);
        label1.addStyleName(ValoTheme.LABEL_SMALL);
        label2.addStyleName(ValoTheme.LABEL_SMALL);
        addComponent(label);
        addComponent(label1);
        addComponent(label2);
    }
}
