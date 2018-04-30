package eu.sii.pl.velka.view;

import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;
import eu.sii.pl.velka.view.viewModel.DebtTableView;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DebtTableViewTest {

    Debt debt;
    DebtTableView debtTableView;


    @Before
    public void init() {
        CreditCard creditCard = new CreditCard(
                "232345", "222", "Ana", "Smith");
        Payment payment = new Payment(1L, LocalDate.now(), new BigDecimal(30), creditCard, null);
        Payment payment1 = new Payment(1L, LocalDate.now(), new BigDecimal(130), creditCard, null);
        Set<Payment> payments = new HashSet<Payment>(Arrays.asList(payment, payment1));

        debt = new Debt(1L, new BigDecimal(200), LocalDate.now(), payments);
        debtTableView=new DebtTableView(debt);
    }



    @Test
    public void shouldReturnDebtorData(){
        //when
    Long debtViewId=debtTableView.getDebtViewId();
    LocalDate debtViewDate=debtTableView.getDebtViewDate();
    BigDecimal debtAmountView=debtTableView.getDebtViewAmount();
    //then
        Assert.assertThat(debtViewId,CoreMatchers.equalTo( 1L));
        Assert.assertThat(debtViewDate,CoreMatchers.equalTo( LocalDate.now()));
        Assert.assertThat(debtAmountView,CoreMatchers.equalTo( new BigDecimal(200)));
    }
    @Test
    public void shouldReturnRemainAmount(){
        //when
        BigDecimal remainAmount=debtTableView.getRemainingAmountView();
        //then
        Assert.assertThat(remainAmount,CoreMatchers.equalTo( new BigDecimal(40).setScale(2)));

    }

}
