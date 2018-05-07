package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(BalanceController.class)
public class BalanceControllerTest {

    @Autowired
    private BalanceController balanceController;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    private String jsonResponse = "{\"id\":1,\"firstName\":\"Joe\",\"lastName\":\"Doe\",\"ssn\"" +
            ":\"980-122-112\",\"listOfDebts\":[{\"id\":1,\"debtAmount\":50000.00,\"" +
            "repaymentDate\":\"2018-04-30\",\"listOfPayments\":[{\"id\":2,\"repaymentDate\"" +
            ":\"2018-04-30\",\"paymentAmount\":500.00,\"creditCard\":{\"id\":2,\"cvv\":\"109\"," +
            "\"CCNumber\":\"98978872537125\",\"firstName\":\"Joe\",\"lastName\":\"Doe\"}}," +
            "{\"id\":1,\"repaymentDate\":\"2018-04-30\",\"paymentAmount\":700.00,\"creditCard\":" +
            "{\"id\":1,\"cvv\":\"235\",\"CCNumber\":\"23457590909018\",\"firstName\":\"Joe\",\"" +
            "lastName\":\"Doe\"}}]},{\"id\":2,\"debtAmount\":60000.00,\"repaymentDate\"" +
            ":\"2018-04-30\",\"listOfPayments\":[{\"id\":3,\"repaymentDate\":\"2018-04-30\"," +
            "\"paymentAmount\":700.00,\"creditCard\":{\"id\":1,\"cvv\":\"235\",\"CCNumber\":" +
            "\"23457590909018\",\"firstName\":\"Joe\",\"lastName\":\"Doe\"}},{\"id\":4," +
            "\"repaymentDate\":\"2018-04-30\",\"paymentAmount\":700.00,\"creditCard\":" +
            "{\"id\":1,\"cvv\":\"235\",\"CCNumber\":\"23457590909018\",\"firstName\":\"Joe\"," +
            "\"lastName\":\"Doe\"}}]}]}"; //credit to Miłosz

    @Test
    public void shouldCallApiForFullData() throws Exception {
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/balance/980-122-111"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withSuccess(jsonResponse, MediaType.APPLICATION_JSON ));
        Debtor debtor = balanceController.getFullData("980-122-111");
        Assertions.assertThat(!debtor.getLastName().isEmpty());
    }

}