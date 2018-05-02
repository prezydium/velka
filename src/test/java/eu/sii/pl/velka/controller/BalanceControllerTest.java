package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BalanceControllerTest {
    BalanceController balanceController = new BalanceController();

    @Test
    public void shouldReturnDebtorFromUrl() {
        Debtor debtor = balanceController.getDebtorBalance("980-122-111");
        Assert.assertThat(debtor.getFirstName(), CoreMatchers.equalTo("Jakub"));
        Assert.assertThat(debtor.getLastName(), CoreMatchers.equalTo(" Watus"));
        Assert.assertThat(debtor.getSsn(), CoreMatchers.equalTo(" 980-122-111"));

    }

}
