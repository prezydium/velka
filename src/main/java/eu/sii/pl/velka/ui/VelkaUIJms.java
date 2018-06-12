package eu.sii.pl.velka.ui;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.ui.authorisation.ErrorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

@SpringUI
@Theme("valo")
@SpringViewDisplay
@Push
@Profile("jms")
public class VelkaUIJms extends UI {

    @Autowired
    private SessionMap sessionMap;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Velka");
        getNavigator().setErrorView(ErrorView.class);
        sessionMap.addUIToMap(getEmbedId(), getUI());
        addDetachListener((DetachListener) event -> sessionMap.removeUIFromStorage(getEmbedId()));
    }
}
