package eu.sii.pl.velka.view;

import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.Payment;
import eu.sii.pl.velka.utils.DebtorSummaryData;
import eu.sii.pl.velka.view.viewModel.DebtorTableView;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DebtorTableViewTest {

    Debtor debtor;
    DebtorTableView debtorTableView;


    @Before
    public void init() {


        Payment payment = new Payment(1L, LocalDate.now(), new BigDecimal(30), null, null);
        Payment payment1 = new Payment(1L, LocalDate.now(), new BigDecimal(130), null, null);
        Set<Payment> payments = new HashSet<Payment>(Arrays.asList(payment, payment1));

        Debt debt = new Debt(1L, new BigDecimal(200), LocalDate.now(), payments);
        Debt debt1 = new Debt(1L, new BigDecimal(400), LocalDate.now(), payments);
        Debt debtNullPayments = new Debt(1L, new BigDecimal(400), LocalDate.now(), null);

        Set<Debt> debts = new HashSet<Debt>(Arrays.asList(debt, debt1));
        Set<Debt> debtsNullPayment = new HashSet<Debt>(Arrays.asList(debtNullPayments));
        debtor = new Debtor("Ana", "Smith", "232122333", debts);
       debtorTableView=new DebtorTableView(debtor);
    }


    @Test
    public void shouldReturnDebtorData(){

        String firstName=debtorTableView.getFirstName();
        String lastName=debtorTableView.getLastName();
        String ssn=debtorTableView.getSsn();
        Assert.assertThat(firstName,CoreMatchers.equalTo("Ana"));
        Assert.assertThat(lastName,CoreMatchers.equalTo("Smith"));
        Assert.assertThat(ssn,CoreMatchers.equalTo("232122333"));
    }




    @Test
    public void shouldReturnRemainingAmountSum(){
        //given

        //when
        BigDecimal remainingAmountSum= debtorTableView.getRemainingAmountSumView();
        //then
        Assert.assertThat(remainingAmountSum,CoreMatchers.equalTo(new BigDecimal(280).setScale(2)));

    }

    @Test
    public void shouldReturnDebtsSum(){
        //given
        //when
        BigDecimal debtsSumAmount= debtorTableView.getDebtsSumView();
        //then
        Assert.assertThat(debtsSumAmount,CoreMatchers.equalTo(new BigDecimal(600).setScale(2)));

    }

}
