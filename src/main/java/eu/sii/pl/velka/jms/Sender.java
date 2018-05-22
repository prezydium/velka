package eu.sii.pl.velka.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;
}
