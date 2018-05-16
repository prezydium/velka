package eu.sii.pl.velka.ui.authorisation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ErrorLoginView.VIEW_NAME)
public class ErrorLoginView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "error";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Communication error", "Please try again later",
                Notification.Type.ERROR_MESSAGE);
        UI.getCurrent().getNavigator().navigateTo("");
    }
}
