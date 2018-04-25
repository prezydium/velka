package eu.sii.pl.velka.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.controller.DebtorController;
import eu.sii.pl.velka.model.Debtor;

import static eu.sii.pl.velka.view.VelkaUI.LOGINEFFECT;

public class StartView extends VerticalLayout implements View {


    private StartForm formLayout = new StartForm(this::clickSubmitButton);

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addHeader();
        addForm();
        Debtor debtor = new Debtor();
        formLayout.setModel(debtor);
    }

    private void addHeader() {
        Label header = new Label("Welcome to Velka application - pay your debts before we pay you a visit");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        this.addComponent(header);
    }

    private void addForm() {
        this.addComponent(formLayout);
    }

    private void clickSubmitButton(Button.ClickEvent clickEvent) { ;
        System.out.println(new DebtorController().confirmThatDebtorExists().toString()); //test
        UI.getCurrent().getNavigator().navigateTo(LOGINEFFECT);

        Debtor localDebtor = formLayout.getModel();
        System.out.println(localDebtor.getSsn());
    }

}
