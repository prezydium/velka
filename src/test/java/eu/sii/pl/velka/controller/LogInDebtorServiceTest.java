package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
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

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/testapplication.properties")
@RestClientTest(LogInDebtorService.class)
public class LogInDebtorServiceTest {

    @Autowired
    private LogInDebtorService logInDebtorService;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    private Debtor debtor;

    @Before
    public void setUp() {
        debtor = new Debtor("Adam", "Pawłowicz", "999-999-999", Collections.EMPTY_LIST);
    }

    @Test
    public void shouldGetValueFromPropertiesFile() {
        //when
        String testUrl = logInDebtorService.getAPI_URL();
        //then
        assertFalse(testUrl.isEmpty());
    }

    @Test
    public void shouldNotThrowException() {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/login/"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST))
                .andRespond(MockRestResponseCreators.withServerError());
        //when
        AuthorisationEffect actual = logInDebtorService.confirmThatDebtorExists(debtor);
        //then
        assertEquals(AuthorisationEffect.ERROR, actual);
    }

    @Test
    public void shouldReturnAuthorisationEffectAsRecognised() {
        //given
        mockRestServiceServer.expect(MockRestRequestMatchers
                .requestTo("/TEST_URL/login/"))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.POST))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK));
        //when
        AuthorisationEffect actual = logInDebtorService.confirmThatDebtorExists(debtor);
        //then
        assertEquals(AuthorisationEffect.RECOGNISED, actual);
    }
}