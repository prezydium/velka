package eu.sii.pl.velka.view;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.navigator.Navigator;




@SpringUI
@Theme("valo")
public class VelkaUI extends UI {

  com.vaadin.navigator.Navigator navigator;

  protected static final String BALANCEVIEW="";


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        getPage().setTitle("Velka");
        navigator= new Navigator(this, this);
        navigator.addView(BALANCEVIEW, new BalanceView());
    }
}
