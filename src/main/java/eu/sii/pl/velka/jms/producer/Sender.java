package eu.sii.pl.velka.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.TextMessage;

public class Sender {
        private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

        @Autowired
        private JmsTemplate jmsTemplate;

        public void send(String destination,TextMessage message) {
            LOGGER.info("sending message='{}' to destination='{}'", message, destination);
            jmsTemplate.convertAndSend(destination, message);
        }
    }

