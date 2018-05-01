package eu.sii.pl.velka.view;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.view.authorisationeffect.ErrorLoginView;
import eu.sii.pl.velka.view.authorisationeffect.SuccessfulLoginView;
import eu.sii.pl.velka.view.authorisationeffect.UnrecognisedUserLoginView;

@SpringUI
@Theme("valo")
@SpringViewDisplay
public class VelkaUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");
    }
}
