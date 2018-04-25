package eu.sii.pl.velka.view;

import com.vaadin.annotations.PropertyId;
import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import eu.sii.pl.velka.model.Debtor;

public class StartForm extends VerticalLayout {


    private Binder binder = new Binder<>(Debtor.class);

    @PropertyId("name")
    private TextField textFieldName = new TextField("Name: ");

    @PropertyId("surname")
    private TextField textFieldSurname = new TextField("Surname: ");

    @PropertyId("ssn")
    private TextField textFieldSsn = new TextField("SSN: ");

    public  StartForm(Button.ClickListener clickListener){
        binder.bindInstanceFields(this);
        textFieldName.setWidth("50%");
        textFieldSurname.setWidth("50%");
        textFieldSsn.setWidth("50%");

        Button confirmButton = new Button("Submit", clickListener);

        setSpacing(true);
        setWidth("80%");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addComponents(textFieldName, textFieldSurname, textFieldSsn, confirmButton);
    }

    public void setModel(Debtor debtor){
        binder.setBean(debtor);

    }
    public Debtor getModel(){

        return (Debtor) binder.getBean();
    }

}
