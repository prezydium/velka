package eu.sii.pl.velka.ui.viewfactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.PaymentPlan;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentPlanResponse implements ResponseTargetI {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void execute(ActiveMQTextMessage textMessage) {
        PaymentPlan paymentPlan = null;
        try {
            paymentPlan = objectMapper.readValue(textMessage.getText(), PaymentPlan.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UI.getCurrent().getSession().setAttribute("paymentPlan", paymentPlan);
    }
}
