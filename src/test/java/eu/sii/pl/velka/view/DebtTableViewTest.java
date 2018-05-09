package eu.sii.pl.velka.view;

import eu.sii.pl.velka.dataHolder.DebtCreator;
import eu.sii.pl.velka.view.viewModel.DebtTableView;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class DebtTableViewTest {

    @Autowired
    DebtCreator debtCreator = new DebtCreator();
    @Autowired
    DebtTableView debtTableView;

    @Before
    public void init() {
        debtTableView = new DebtTableView(debtCreator.createDebt());
    }

    @Test
    public void shouldReturnDebtorData() {
        //when
        String debtViewName = debtTableView.getDebtViewName();
        LocalDate debtViewDate = debtTableView.getDebtViewDate();
        BigDecimal debtAmountView = debtTableView.getDebtViewAmount();
        //then
        //assertThat(debtViewName, equalTo(1L));
        assertThat(debtViewDate, equalTo(LocalDate.now()));
        assertThat(debtAmountView, equalTo(new BigDecimal(200)));
    }

    @Test
    public void shouldReturnRemainAmount() {
        //when
        BigDecimal remainAmount = debtTableView.getRemainingAmountView();
        //then
        assertThat(remainAmount, equalTo(new BigDecimal(40).setScale(2)));
    }
}
