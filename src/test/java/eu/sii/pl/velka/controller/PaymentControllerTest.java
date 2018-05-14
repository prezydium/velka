package eu.sii.pl.velka.controller;


import eu.sii.pl.velka.model.PaymentDeclaration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(PaymentController.class)
public class PaymentControllerTest {

    @Autowired
    private PaymentController paymentController;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    private PaymentDeclaration paymentDeclaration;

    @Before
    public void setUp() {
        paymentDeclaration = new PaymentDeclaration(new BigDecimal("100.00"), "999888777666", "980-122-111");
    }
}
