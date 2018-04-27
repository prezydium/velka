package eu.sii.pl.velka.view;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
@Theme("valo")
public class VelkaUI extends UI {

    private Navigator navigator;

    public static final String STARTVIEW = "";
    public static final String SUCCESSFULOGINVIEW = "logged";
    public static final String FAILEDOGINVIEW = "notlogged";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");

        navigator = new Navigator(this, this);

        navigator.addView(STARTVIEW, new StartView());
        navigator.addView(SUCCESSFULOGINVIEW, new SuccessfulLoginView());
        navigator.addView(FAILEDOGINVIEW, new UnrecognisedUserLoginView());
    }
}
