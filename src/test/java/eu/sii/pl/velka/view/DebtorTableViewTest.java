package eu.sii.pl.velka.view;

import eu.sii.pl.velka.dataHolder.DebtorCreator;
import eu.sii.pl.velka.view.viewModel.DebtorTableView;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class DebtorTableViewTest {

    @Autowired
    DebtorCreator debtorCreator = new DebtorCreator();
    DebtorTableView debtorTableView;

    @Before
    public void init() {
        debtorTableView = new DebtorTableView(debtorCreator.createDebtor());
    }

    @Test
    public void shouldReturnDebtorData() {
        //given
        //when
        String firstName = debtorTableView.getFirstName();
        String lastName = debtorTableView.getLastName();
        String ssn = debtorTableView.getSsn();
        //then
        Assert.assertThat(firstName, CoreMatchers.equalTo("Ana"));
        Assert.assertThat(lastName, CoreMatchers.equalTo("Smith"));
        Assert.assertThat(ssn, CoreMatchers.equalTo("232122333"));
    }

    @Test
    public void shouldReturnRemainingAmountSum() {
        //given
        //when
        BigDecimal remainingAmountSum = debtorTableView.getRemainingAmountSumView();
        //then
        Assert.assertThat(remainingAmountSum, CoreMatchers.equalTo(new BigDecimal(280).setScale(2)));
    }

    @Test
    public void shouldReturnDebtsSum() {
        //given
        //when
        BigDecimal debtsSumAmount = debtorTableView.getDebtsSumView();
        //then
        Assert.assertThat(debtsSumAmount, CoreMatchers.equalTo(new BigDecimal(600).setScale(2)));
    }
}
