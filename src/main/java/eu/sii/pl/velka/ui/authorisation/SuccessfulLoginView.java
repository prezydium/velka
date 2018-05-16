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
        Notification successfulLoginNotiffication = new Notification("Welcome to MiCuenta", "How are you today?");
        successfulLoginNotiffication.setDelayMsec(-1);
        successfulLoginNotiffication.show(Page.getCurrent());
    }
}
