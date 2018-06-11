package eu.sii.pl.velka.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.service.BalanceService;
import eu.sii.pl.velka.session.SessionMap;
import eu.sii.pl.velka.ui.authorisation.ErrorView;
import eu.sii.pl.velka.ui.views.JmsResponseSwitch;
import eu.sii.pl.velka.ui.views.SuccessfulPaymentView;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

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
        sessionMap.addUIToMap(getUI());
    }
}
