package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.view.authorisation.SuccessfulLoginView;
import org.junit.Assert;
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

import java.util.Collections;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(LogInDebtorController.class)
public class LogInDebtorControllerTest {

    @Autowired
    private LogInDebtorController logInDebtorController;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    private Debtor debtor;

    @Before
    public void setUp() {
        debtor = new Debtor("Adam", "Pawłowicz", "999-999-999", Collections.EMPTY_SET);
    }

    @Test
    public void shouldGetValueFromPropertiesFile() {
        //when
        String testUrl = logInDebtorController.getAPI_URL();
        //then
        Assert.assertFalse(testUrl.isEmpty());
    }

    @Test
    public void shouldNotThrowException() {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST)).andRespond(MockRestResponseCreators.withServerError());
        //when
        logInDebtorController.confirmThatDebtorExists(debtor);
    }

    @Test
    public void shouldSetNavigationTargetToSuccessfulLoginView() {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST)).andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK));

        //when
        logInDebtorController.confirmThatDebtorExists(debtor);

        //then
        Assert.assertEquals(SuccessfulLoginView.VIEW_NAME, logInDebtorController.getNavigationTarget());
    }
}