package eu.sii.pl.velka.view.authorisation;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = UnrecognisedUserLoginView.VIEW_NAME)
public class UnrecognisedUserLoginView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "unrecognised";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Unrecognised debtor data", "Please check your credentials",
                Notification.Type.ERROR_MESSAGE);
        UI.getCurrent().getNavigator().navigateTo("");
    }
}
