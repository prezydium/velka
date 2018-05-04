package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class BalanceControllerTest {
    BalanceController balanceController = new BalanceController();

    @Test
    public void shouldReturnDebtorFromUrl() {
        Debtor debtor = balanceController.getDebtorBalance("980-122-111");
        assertThat(debtor.getFirstName(), equalTo("Jakub"));
        assertThat(debtor.getLastName(), equalTo(" Watus"));
        assertThat(debtor.getSsn(), equalTo(" 980-122-111"));

    }

}
