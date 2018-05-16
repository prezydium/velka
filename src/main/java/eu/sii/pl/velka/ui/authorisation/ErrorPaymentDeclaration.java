package eu.sii.pl.velka.ui.authorisation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@UIScope
@SpringView(name = ErrorPaymentDeclaration.VIEW_NAME)
public class ErrorPaymentDeclaration extends VerticalLayout implements View {

    public static final String VIEW_NAME = "errorPayment";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Something gone wrong :/", "Did you entered correct data?", Notification.Type.WARNING_MESSAGE);
        UI.getCurrent().getNavigator().navigateTo("balance");
    }
}

