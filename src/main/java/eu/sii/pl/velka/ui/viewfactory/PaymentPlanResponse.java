package eu.sii.pl.velka.ui.viewfactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.ui.UI;
import eu.sii.pl.velka.model.PaymentPlan;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentPlanResponse implements ResponseTargetI {

    private final static Logger LOG = LoggerFactory.getLogger(PaymentPlanResponse.class);

    private final ObjectMapper objectMapper;

    @Autowired
    public PaymentPlanResponse(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void execute(ActiveMQTextMessage textMessage) {
        PaymentPlan paymentPlan = null;
        try {
            paymentPlan = objectMapper.readValue(textMessage.getText(), PaymentPlan.class);
        } catch (Exception e) {
            LOG.error("Error switching view during PaymentPlanResponse: " + e.getMessage());
        }
        UI.getCurrent().getSession().setAttribute("paymentPlan", paymentPlan);
    }
}
