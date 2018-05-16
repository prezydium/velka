package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.dataHolder.ResourcesProvider;
import eu.sii.pl.velka.model.PaymentDeclaration;
import eu.sii.pl.velka.model.PaymentPlan;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(PaymentController.class)
public class PaymentControllerTest {

    @Autowired
    private PaymentController paymentController;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    private String jsonResponse = ResourcesProvider.getFileContent("paymentPlan.json");

    private PaymentDeclaration paymentDeclaration;

    @Before
    public void setUp() {
        paymentDeclaration = new PaymentDeclaration(new BigDecimal(10), "999888777666", "980-122-111");
    }

    public PaymentControllerTest() throws IOException {
    }

    @Test
    public void shouldCallApiForFullData() throws Exception {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/paymentplan"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST))
                .andRespond(MockRestResponseCreators.withSuccess(jsonResponse, MediaType.APPLICATION_JSON));
        PaymentPlan paymentplan = paymentController.getPaymentPlan(paymentDeclaration);
        Assertions.assertThat(!paymentplan.getSsn().isEmpty());
        Assertions.assertThat(!paymentplan.getMessage().isEmpty());
        Assertions.assertThat(!paymentplan.getPlannedPaymentList().isEmpty());
    }

    @Test
    public void shouldReturnAuthorisationEffectAsRecognised() {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/paymentplan"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK));
        //when
        AuthorisationEffect actual = paymentController.trySendPayment(paymentDeclaration);
        //then
        assertEquals(AuthorisationEffect.RECOGNISED, actual);
    }
}
