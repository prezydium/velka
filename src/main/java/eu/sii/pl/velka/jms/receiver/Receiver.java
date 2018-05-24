package eu.sii.pl.velka.jms.receiver;

import com.vaadin.server.VaadinSession;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "jms.queue.login.velka")
    public void receiveStatus(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }
    @JmsListener(destination = "jms.queue.balance.velka")
    public void receiveBalance(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }
    @JmsListener(destination = "jms.queue.paymentplan.velka")
    public void receivePlan(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }
    @JmsListener(destination = "jms.queue.paymentsupdate.velka")
    public void receiveupdate(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }
}
