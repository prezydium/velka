package eu.sii.pl.velka.ui.views.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.model.PaymentPlan;

public class HeaderPaymentPlan extends VerticalLayout {

    public HeaderPaymentPlan(PaymentPlan paymentPlan) {
        Label label = new Label();
        Label label1 = new Label();
        label.setValue("Snn: " + paymentPlan.getSsn());
        label1.setValue("Message:  " + paymentPlan.getMessage());
        label.addStyleName(ValoTheme.LABEL_SMALL);
        label1.addStyleName(ValoTheme.LABEL_SMALL);
        addComponent(label);
        addComponent(label1);
    }
}
