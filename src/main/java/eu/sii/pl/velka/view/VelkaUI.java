package eu.sii.pl.velka.view;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.view.authorisation.ErrorView;
import org.springframework.beans.factory.annotation.Autowired;
import sun.plugin.javascript.navig.Navigator;

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
