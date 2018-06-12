package eu.sii.pl.velka.conf;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

@Configuration
@ComponentScan("eu.sii.pl.velka")
@EnableJms
public class AppConfig {

    private String brokerUrl = "tcp://localhost:61616";
    //"tcp://ec2-34-245-25-132.eu-west-1.compute.amazonaws.com:7030";


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


