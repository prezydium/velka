package eu.sii.pl.velka.ui.windows.forms;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.ui.windows.forms.CreditCardForm;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Java6Assertions.assertThat;


public class CreditCardFormTest {

    private CreditCardForm creditCardForm;
    List<Component> componentList = new ArrayList<>();

    @Before
    public void setUp() {
        creditCardForm = new CreditCardForm(new Debtor("One", "Two", "111-111-111", Collections.emptyList()));
        for (int i = 0; i < creditCardForm.getComponentCount(); i++) {
            componentList.add(creditCardForm.getComponent(i));
        }
    }

    @Test
    public void shouldCreateFormWithButton() {
        assertTrue(componentList.stream().anyMatch(x -> x instanceof Button));
    }

    @Test
    public void shouldCreateFormWithAnyTextField() {
        assertTrue(componentList.stream().anyMatch(x -> x instanceof TextField));
    }

    @Test
    public void shouldBindDataToCreditCardForm() {
        assertThat(creditCardForm.getModelClass().getName()).endsWith("CreditCard");
    }
}