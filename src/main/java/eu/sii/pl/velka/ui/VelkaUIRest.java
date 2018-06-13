package eu.sii.pl.velka.ui;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.ui.authorisation.ErrorView;
import org.springframework.context.annotation.Profile;

@SpringUI
@Theme("valo")
@SpringViewDisplay
@Push
@Profile("!jms")
public class VelkaUIRest extends UI {

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");
        getNavigator().setErrorView(ErrorView.class);
    }
}
