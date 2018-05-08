package eu.sii.pl.velka.view;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.controller.CommunicationController;
import eu.sii.pl.velka.controller.LogInDebtorController;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = StartView.VIEW_NAME)
public class StartView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    @Autowired
    private CommunicationController communicateWithAPI;

    private StartForm formLayout = new StartForm(this::clickSubmitButton);

    public StartView(){
        this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addHeader();
        addForm();
        Debtor debtor = new Debtor();
        formLayout.setModel(debtor);
    }

    private void addHeader() {
        Label header = new Label("Welcome to Velka application - pay your debts before we pay you a visit");
        header.addStyleName(ValoTheme.LABEL_H1);
        this.addComponent(header);
    }

    private void addForm() {
        this.addComponent(formLayout);
    }

    private void clickSubmitButton(Button.ClickEvent clickEvent) {
        Debtor localDebtor = (Debtor) formLayout.getModel();
        communicateWithAPI.communicateWithAPI(localDebtor);
    }
}