package eu.sii.pl.velka.UI.views;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;
import eu.sii.pl.velka.UI.views.components.HeaderLayout;
import eu.sii.pl.velka.UI.views.components.TablePannedPayment;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;

@SpringView(name = "paymentPlan")
public class PaymentPlanView extends VerticalLayout implements View {

    public PaymentPlanView() {
        Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
        PaymentPlan paymentPlan = (PaymentPlan) VaadinSession.getCurrent().getAttribute("paymentPlan");
        this.addComponent(new HeaderLayout(debtor));
        this.addComponent(new TablePannedPayment(debtor, paymentPlan));
    }
}
