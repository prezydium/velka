package eu.sii.pl.velka.UI.authorisation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@UIScope
@SpringView(name = ErrorView.VIEW_NAME)
public class ErrorView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "error";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("There is no such page", "Did you entered correct address?", Notification.Type.WARNING_MESSAGE);
        UI.getCurrent().getNavigator().navigateTo("");
    }
}
