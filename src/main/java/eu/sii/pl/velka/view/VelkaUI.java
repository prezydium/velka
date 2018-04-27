package eu.sii.pl.velka.view;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.view.authorisationeffect.ErrorLoginView;
import eu.sii.pl.velka.view.authorisationeffect.SuccessfulLoginView;
import eu.sii.pl.velka.view.authorisationeffect.UnrecognisedUserLoginView;

@SpringUI
@Theme("valo")
public class VelkaUI extends UI {

    private Navigator navigator;

    public static final String STARTVIEW = "";
    public static final String SUCCESSFULOGINVIEW = "logged";
    public static final String UNRECOGNISED = "unrecognised";
    public static final String ERROR = "error";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");

        navigator = new Navigator(this, this);

        navigator.addView(STARTVIEW, new StartView());
        navigator.addView(SUCCESSFULOGINVIEW, new SuccessfulLoginView());
        navigator.addView(UNRECOGNISED, new UnrecognisedUserLoginView());
        navigator.addView(ERROR, new ErrorLoginView());
    }
}
