package eu.sii.pl.velka.UI.views;

import com.vaadin.data.BinderValidationStatus;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.UI.views.components.StartForm;
import eu.sii.pl.velka.controller.CommunicationWIthMiCuentaAPIController;
import eu.sii.pl.velka.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = StartView.VIEW_NAME)
public class StartView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    @Autowired
    private CommunicationWIthMiCuentaAPIController communicateWithAPI;

    private StartForm formLayout = new StartForm(this::clickSubmitButton);

    public StartView() {
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
        BinderValidationStatus<Debtor> status = formLayout.getBinder().validate();
        if (status.hasErrors()) {
            Notification.show("Validation error: "
                    + status.getValidationErrors().get(0).getErrorMessage());
        } else {
            Debtor localDebtor = (Debtor) formLayout.getModel();
            communicateWithAPI.communicateWithAPI(localDebtor);
        }
    }
}
