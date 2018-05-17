package eu.sii.pl.velka.ui.views.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.ui.viewModel.DebtorTableView;
import eu.sii.pl.velka.model.Debtor;

public class HeaderLayout extends VerticalLayout {

    public HeaderLayout(Debtor debtor) {
        Label firstNameLabel = new Label();
        Label lastNameLabel = new Label();
        Label ssnLabel = new Label();
        firstNameLabel.setValue("First Name: " + debtor.getFirstName());
        lastNameLabel.setValue("Last Name:  " + debtor.getLastName());
        ssnLabel.setValue("SSN: " + debtor.getSsn());
        firstNameLabel.addStyleName(ValoTheme.LABEL_BOLD);
        lastNameLabel.addStyleName(ValoTheme.LABEL_BOLD);
        ssnLabel.addStyleName(ValoTheme.LABEL_BOLD);
        addComponents(firstNameLabel, lastNameLabel, ssnLabel);
    }
}
