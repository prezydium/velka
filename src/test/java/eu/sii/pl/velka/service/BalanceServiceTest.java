package eu.sii.pl.velka.service;

import eu.sii.pl.velka.LoadFile;
import eu.sii.pl.velka.model.Debtor;
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

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(BalanceService.class)
public class BalanceServiceTest {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    private String jsonResponse = LoadFile.loadJsonFile("balance.json");

    public BalanceServiceTest() throws IOException {
    }

    @Test
    public void shouldCallApiForFullData() throws Exception {
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/balance/980-122-111"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withSuccess(jsonResponse, MediaType.APPLICATION_JSON ));
        Debtor debtor = balanceService.getFullData("980-122-111");
        assertThat(!debtor.getLastName().isEmpty());
        assertThat(!debtor.getFirstName().isEmpty());
        assertThat(!debtor.getSsn().isEmpty());
    }
}