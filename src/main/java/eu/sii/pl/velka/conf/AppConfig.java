package eu.sii.pl.velka.conf;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

@Configuration
@ComponentScan("eu.sii.pl.velka")
public class AppConfig {

    private String brokerUrl = "tcp://ec2-34-245-25-132.eu-west-1.compute.amazonaws.com:7030";

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("jms.queue.login");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        return factory;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate(activeMQConnectionFactory());
    }

}


