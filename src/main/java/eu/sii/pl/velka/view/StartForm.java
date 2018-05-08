package eu.sii.pl.velka.view;

import com.vaadin.annotations.PropertyId;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.model.Debtor;

public class StartForm extends AbstractDataForm<Debtor> {

    private Label formHeader = new Label("Enter your details to see your debts");

    @PropertyId("firstName")
    private TextField textFieldName = new TextField("Name: ");

    @PropertyId("lastName")
    private TextField textFieldSurname = new TextField("Surname: ");

    @PropertyId("ssn")
    private TextField textFieldSsn = new TextField("SSN: ");

    public StartForm(Button.ClickListener clickListener) {
        super();
        binder.bindInstanceFields(this);
        styleUI();
        Button confirmButton = new Button("Submit", clickListener);
        addComponents(formHeader, textFieldName, textFieldSurname, textFieldSsn, confirmButton);
    }

    private void styleUI() {
        textFieldName.setWidth("50%");
        textFieldSurname.setWidth("50%");
        textFieldSsn.setWidth("50%");
        formHeader.addStyleName(ValoTheme.TEXTFIELD_HUGE);
        setSpacing(true);
        setWidth("80%");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    }

    @Override
    protected Class<Debtor> getModelClass() {
        return Debtor.class;
    }
}
