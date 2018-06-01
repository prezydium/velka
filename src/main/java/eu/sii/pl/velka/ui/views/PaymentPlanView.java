package eu.sii.pl.velka.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.*;
import eu.sii.pl.velka.ui.views.components.HeaderPaymentPlan;
import eu.sii.pl.velka.ui.views.components.TablePlannedPayment;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.ui.windows.PaymentMethodWindow;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = PaymentPlanView.VIEW_NAME)
public class PaymentPlanView extends VerticalLayout implements View {

    public final static String VIEW_NAME = "paymentPlan";

    private Button paymentButton = new Button("Choose payment method", this::paymentButtonClick);

    private Button backToBalanceButton = new Button("Go back to balance", this::backToBalanceClick);

    private HorizontalLayout buttonLayout = new HorizontalLayout();

    @Autowired
    private SpringNavigator springNavigator;

    public PaymentPlanView() {
        Debtor debtor = (Debtor) VaadinSession.getCurrent().getAttribute("debtor");
        PaymentPlan paymentPlan = (PaymentPlan) VaadinSession.getCurrent().getAttribute("paymentplan");
        this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.addComponent(new HeaderPaymentPlan(paymentPlan));
        this.addComponent(new TablePlannedPayment(debtor, paymentPlan));
        buttonLayout.addComponents(paymentButton, backToBalanceButton);
        this.addComponents(buttonLayout);

    }

    private void paymentButtonClick(Button.ClickEvent clickEvent) {
        UI.getCurrent().addWindow(new PaymentMethodWindow((Debtor) VaadinSession.getCurrent().getAttribute("debtor")));
    }

    private void backToBalanceClick(Button.ClickEvent clickEvent) {
        springNavigator.navigateTo(BalanceView.VIEW_NAME);
    }
}
