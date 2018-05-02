package eu.sii.pl.velka.view;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.navigator.Navigator;


@SpringUI
@Theme("valo")
@SpringViewDisplay
public class VelkaUI extends UI {




    @Override
    protected void init(VaadinRequest vaadinRequest) {

        getPage().setTitle("Velka");

    }
}
