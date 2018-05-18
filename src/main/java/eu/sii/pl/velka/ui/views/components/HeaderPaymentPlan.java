package eu.sii.pl.velka.ui.views.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.model.PaymentPlan;

public class HeaderPaymentPlan extends VerticalLayout {

    public HeaderPaymentPlan(PaymentPlan paymentPlan) {
        Label ssnLabel = new Label();
        Label messageLabel = new Label();
        ssnLabel.setValue("Snn: " + paymentPlan.getSsn());
        messageLabel.setValue("Message:  " + paymentPlan.getMessage());
        ssnLabel.addStyleName(ValoTheme.LABEL_BOLD);
        messageLabel.addStyleName(ValoTheme.LABEL_SUCCESS);
        addComponent(ssnLabel);
        addComponent(messageLabel);
    }
}
