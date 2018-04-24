package eu.sii.pl.velka.view;

import com.vaadin.annotations.PropertyId;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


import static eu.sii.pl.velka.view.VelkaUI.LOGINEFFECT;

public class StartView extends VerticalLayout implements View {

    @Autowired
    private Navigator navigator;

    @PropertyId("name")
    private TextField textFieldName = new TextField("Name: ");

    @PropertyId("surname")
    private TextField textFieldSurname = new TextField("Surname: ");

    @PropertyId("ssn")
    private TextField textFieldSsn = new TextField("SSN: ");


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addHeader();
        addForm();
    }

    private void addHeader() {
        Label header = new Label("Welcome to Velka application - pay your debts before we pay you a visit");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        this.addComponent(header);
    }

    private void addForm() {


        VerticalLayout formLayout = new VerticalLayout();




        textFieldName.setWidth("50%");
        textFieldSurname.setWidth("50%");
        textFieldSsn.setWidth("50%");

        Button confirmButton = new Button("Submit", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                UI.getCurrent().getNavigator().navigateTo(LOGINEFFECT);
            }
        });

        formLayout.setSpacing(true);
        formLayout.setWidth("80%");
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.addComponents(textFieldName, textFieldSurname, textFieldSsn, confirmButton);

        this.addComponent(formLayout);
    }

}
