package eu.sii.pl.velka.ui.windows.forms;

import com.vaadin.ui.Label;
import eu.sii.pl.velka.ui.views.AbstractDataForm;



public class BitCoinForm extends AbstractDataForm {

    /*
    * This is example of non-implemented payment method
    *
    * */

    public static final String PAYMENT_METHOD_NAME = "bitcoin";

    private Label unimplementedLabelInfo = new Label("This method is not yet implemented");

    public BitCoinForm() {
        this.addComponent(unimplementedLabelInfo);
    }

    @Override
    protected Class getModelClass() {
        return new UnsupportedOperationException().getClass();
    }
}
