package eu.sii.pl.velka.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class SuccessfulLoginView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Notification.show("Successful login");
    }

}
