package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.dataHolder.ResourcesProvider;
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

import java.io.IOException;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(BalanceController.class)
public class BalanceControllerTest {

    @Autowired
    private BalanceController balanceController;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    private String jsonResponse = ResourcesProvider.getFileContent("balance.json");

    public BalanceControllerTest() throws IOException {
    }

    @Test
    public void shouldCallApiForFullData() throws Exception {
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/balance/980-122-111"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withSuccess(jsonResponse, MediaType.APPLICATION_JSON ));
        Debtor debtor = balanceController.getFullData("980-122-111");
        Assertions.assertThat(!debtor.getLastName().isEmpty());
        Assertions.assertThat(!debtor.getFirstName().isEmpty());
        Assertions.assertThat(!debtor.getSsn().isEmpty());
    }
}