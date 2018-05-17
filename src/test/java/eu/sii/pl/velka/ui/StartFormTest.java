package eu.sii.pl.velka.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import eu.sii.pl.velka.ui.views.components.StartForm;
import org.junit.Assert;
import org.junit.Test;

public class StartFormTest {

    @Test
    public void shouldCreateFormWhichHaveThreeFieldsAndButton() {
        //given
        int numberOfTextFields = 0;
        int numberOfButtons = 0;

        //when
        StartForm startForm = new StartForm((Button.ClickListener) event -> {
        });

        //then
        for (int i = 0; i < startForm.getComponentCount(); i++) {
            Component c = startForm.getComponent(i);
            if (c instanceof TextField) numberOfTextFields++;
            if (c instanceof Button) numberOfButtons++;
        }
        Assert.assertEquals(3, numberOfTextFields);
        Assert.assertEquals(1, numberOfButtons);
    }

    @Test
    public void checkLabelOfButton() {
        //given
        String labelOnSubmitButton = "";
        //when
        StartForm startForm = new StartForm((Button.ClickListener) event -> {
        });

        //then
        for (Component c : startForm){
            if (c.getCaption() != null && c.getCaption().equals("Submit")){
                labelOnSubmitButton = c.getCaption();
            }
        }
        Assert.assertEquals("Submit", labelOnSubmitButton);
    }
}