package eu.sii.pl.velka.ui.windows.forms;

import com.vaadin.ui.Label;
import eu.sii.pl.velka.ui.views.AbstractDataForm;

public class NotChosenForm extends AbstractDataForm {

    public static final String PAYMENT_METHOD_NAME = "notChosen";

    private Label infoLabel = new Label("Please choose one of available options");

    public NotChosenForm() {
        this.addComponent(infoLabel);
    }

    @Override
    protected Class getModelClass() {
        return this.getClass();
    }
}
