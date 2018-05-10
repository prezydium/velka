package eu.sii.pl.velka.UI;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.UI.authorisation.ErrorView;

@SpringUI
@Theme("valo")
@SpringViewDisplay
public class VelkaUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");
        getNavigator().setErrorView(ErrorView.class);
    }
}
