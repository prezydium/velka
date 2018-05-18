package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.PaymentConfirmation;
import eu.sii.pl.velka.model.PaymentDeclaration;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(PaymentConfirmationService.class)
public class PaymentConfirmationServiceTest {

    @Autowired
    private PaymentConfirmationService paymentConfirmationService;

    private PaymentDeclaration paymentDeclaration;

    private PaymentConfirmation paymentConfirmation;

    @Before
    public void setUp() {
        paymentDeclaration = new PaymentDeclaration(BigDecimal.ZERO, "", "");
        paymentConfirmation = new PaymentConfirmation(paymentDeclaration, null);
    }

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Test
    public void shouldGetResponseOkFromApiAndReturnTrue() throws Exception {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/paymentmethods/creditcard/"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK));
        //then
        Assertions.assertThat(paymentConfirmationService.sendPaymentConfirmation(paymentConfirmation)).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenError() throws Exception {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/paymentmethods/creditcard/"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND));
        //then
        Assertions.assertThat(paymentConfirmationService.sendPaymentConfirmation(paymentConfirmation)).isFalse();
    }
}