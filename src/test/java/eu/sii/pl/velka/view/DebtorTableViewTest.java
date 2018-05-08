package eu.sii.pl.velka.view;

import eu.sii.pl.velka.dataHolder.DebtorCreator;
import eu.sii.pl.velka.view.viewModel.DebtorTableView;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


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
        assertThat(firstName, equalTo("Ana"));
        assertThat(lastName, equalTo("Smith"));
        assertThat(ssn, equalTo("232122333"));
    }

    @Test
    public void shouldReturnRemainingAmountSum() {
        //given
        //when
        BigDecimal remainingAmountSum = debtorTableView.getRemainingAmountSumView();
        //then
        assertThat(remainingAmountSum, equalTo(new BigDecimal(280).setScale(2)));
    }

    @Test
    public void shouldReturnDebtsSum() {
        //given
        //when
        BigDecimal debtsSumAmount = debtorTableView.getDebtsSumView();
        //then
        assertThat(debtsSumAmount, equalTo(new BigDecimal(600).setScale(2)));
    }
}