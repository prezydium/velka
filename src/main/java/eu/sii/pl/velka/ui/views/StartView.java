package eu.sii.pl.velka.ui.views;

import com.google.gson.Gson;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import eu.sii.pl.velka.jms.producer.JmsObjectSender;
import eu.sii.pl.velka.jms.receiver.Receiver;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.service.APIServiceCommunication;
import eu.sii.pl.velka.service.AuthorisationEffect;
import eu.sii.pl.velka.service.BalanceService;
import eu.sii.pl.velka.ui.views.components.StartForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

@SpringView(name = StartView.VIEW_NAME)
public class StartView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    @Autowired
    private JmsObjectSender jmsObjectSender;

    @Autowired
    Receiver receiver;

    @Autowired
    BalanceService balanceService;

    @Autowired
    SpringNavigator springNavigator;

    Gson gson=new Gson();

    @Autowired
    private APIServiceCommunication communicateWithAPI;

    private StartForm formLayout = new StartForm(this::clickSubmitButton);

    public StartView() {
        this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addHeader();
        addForm();
        Debtor debtor = new Debtor();
        formLayout.setModel(debtor);
    }

    private void addHeader() {
        Label header = new Label("Welcome to Velka application - pay your debts before we pay you a visit");
        header.addStyleName(ValoTheme.LABEL_H1);
        this.addComponent(header);
    }

    private void addForm() {
        this.addComponent(formLayout);
    }

    private void clickSubmitButton(Button.ClickEvent clickEvent) {
        BinderValidationStatus<Debtor> status = formLayout.getBinder().validate();
        if (status.hasErrors()) {
            Notification.show("Validation error: "
                    + status.getValidationErrors().get(0).getErrorMessage());
        } else {
            Debtor localDebtor = (Debtor) formLayout.getModel();
           // communicateWithAPI.sentDebtorToAPI(localDebtor);
            jmsObjectSender.sendObject("jms.queue.login", localDebtor);
            if (receiver.getJson().contains("OK")) {
                jmsObjectSender.sendObject("jms.queue.balance", localDebtor.getSsn());
                localDebtor=gson.fromJson(receiver.getJson(), Debtor.class);
                VaadinSession.getCurrent().setAttribute("debtor", localDebtor);
                springNavigator.navigateTo("balance");
            }
        }
    }
}
