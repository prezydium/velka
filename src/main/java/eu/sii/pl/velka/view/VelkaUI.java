package eu.sii.pl.velka.view;


import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI
@Theme("valo")
public class VelkaUI extends UI {


    Navigator navigator;

    protected static final String LOGINEFFECT = "logged";
    protected static final String STARTVIEW = "";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(STARTVIEW, new StartView());
        navigator.addView(LOGINEFFECT, new LogInEffectView());
    }
}
