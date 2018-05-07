package eu.sii.pl.velka;

import eu.sii.pl.velka.model.Debtor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VelkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VelkaApplication.class, args);

    }
}
