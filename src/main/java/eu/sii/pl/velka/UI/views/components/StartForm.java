package eu.sii.pl.velka.UI.views.components;

import com.vaadin.annotations.PropertyId;
import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.UI.views.AbstractDataForm;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.validation.NameValidator;
import eu.sii.pl.velka.validation.SsnValidator;

public class StartForm extends AbstractDataForm<Debtor> {

    private Label formHeader = new Label("Enter your details to see your debts");

    @PropertyId("firstName")
    private TextField textFieldName = new TextField("Name: ");

    @PropertyId("lastName")
    private TextField textFieldSurname = new TextField("Surname: ");

    @PropertyId("ssn")
    private TextField textFieldSsn = new TextField("SSN: ");

    private Label errors = new Label();

    private Button confirmButton;

    public StartForm(Button.ClickListener clickListener) {
        super();
        setUpValidation();
        binder.bindInstanceFields(this);
        styleUI();
        confirmButton = new Button("Submit", clickListener);
        addComponents(formHeader, errors, textFieldName, textFieldSurname, textFieldSsn, confirmButton);
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

    private void setUpValidation() {
        textFieldName.setValueChangeMode(ValueChangeMode.BLUR);
        textFieldSurname.setValueChangeMode(ValueChangeMode.BLUR);
        textFieldSsn.setValueChangeMode(ValueChangeMode.BLUR);
        binder.forMemberField(textFieldName)
                .withValidator(new NameValidator())
                .asRequired();
        binder.forMemberField(textFieldSurname)
                .withValidator(new NameValidator())
                .asRequired();
        binder.forMemberField(textFieldSsn)
                .withValidator(new SsnValidator())
                .asRequired();
    }

    @Override
    protected Class<Debtor> getModelClass() {
        return Debtor.class;
    }

}
