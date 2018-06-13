package eu.sii.pl.velka.ui.viewfactory;

import org.apache.activemq.command.ActiveMQTextMessage;

public interface ResponseTargetI {

    void execute(ActiveMQTextMessage textMessage);
}
