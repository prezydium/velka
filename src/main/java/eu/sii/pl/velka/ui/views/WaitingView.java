package eu.sii.pl.velka.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


@SpringView
public class WaitingView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "waiting";

    private Label infoLabel = new Label("Waiting");

    public WaitingView() {
        addComponent(infoLabel);
    }
}
