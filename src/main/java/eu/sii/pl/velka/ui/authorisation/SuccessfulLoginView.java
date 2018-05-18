package eu.sii.pl.velka.ui.authorisation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = SuccessfulLoginView.VIEW_NAME)
public class SuccessfulLoginView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "successfullogin";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification successfulLoginNotification = new Notification("Welcome to MiCuenta", "How are you today?");
        successfulLoginNotification.setDelayMsec(3);
        successfulLoginNotification.show(Page.getCurrent());
    }
}
