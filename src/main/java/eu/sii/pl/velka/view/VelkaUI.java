package eu.sii.pl.velka.view;


import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class VelkaUI extends UI {


    private VerticalLayout layout;

    @Autowired
    private Debtor debtor;

    Binder<Debtor> binder = new Binder<>();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("Welcome to Velka application - pay your debts before we pay you a visit");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        layout.addComponent(header);
    }

    private void addForm() {
        VerticalLayout formLayout = new VerticalLayout();

        TextField textFieldName = new TextField("Name: ");
        binder.forField(textFieldName).bind(Debtor::getName, Debtor::setName);

        TextField textFieldSurname = new TextField("Surname: ");
        binder.forField(textFieldSurname).bind(Debtor::getSurname, Debtor::setSurname);

        TextField textFieldSsn = new TextField("SSN: ");
        binder.forField(textFieldSsn).bind(Debtor::getSsn, Debtor::setSsn);


        textFieldName.setWidth("50%");
        textFieldSurname.setWidth("50%");
        textFieldSsn.setWidth("50%");

        Button confirmButton = new Button("Check my debt",   event -> {
            try {
                binder.writeBean(debtor);


            } catch (ValidationException e) {
                Notification.show("Debtor data incorrect, " +
                        "please check error messages for each field.");
            }
        });
        confirmButton.setIcon(VaadinIcons.PLUS_CIRCLE);

        formLayout.setSpacing(true);
        formLayout.setWidth("80%");
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.addComponents(textFieldName, textFieldSurname, textFieldSsn, confirmButton);

        layout.addComponent(formLayout);
    }
}
