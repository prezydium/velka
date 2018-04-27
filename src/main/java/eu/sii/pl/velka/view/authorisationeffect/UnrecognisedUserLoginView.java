package eu.sii.pl.velka.view.authorisationeffect;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UnrecognisedUserLoginView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Unrecognised debtor data",
                "Please check your credentials",
                Notification.Type.ERROR_MESSAGE);
        UI.getCurrent().getNavigator().navigateTo("");
    }

}
