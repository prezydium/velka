package eu.sii.pl.velka.ui;

import eu.sii.pl.velka.dataHolder.DebtCreator;
import eu.sii.pl.velka.ui.viewModel.DebtTableView;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DebtTableViewTest {

    private DebtTableView debtTableView;

    @Before
    public void init() {
        debtTableView = new DebtTableView(DebtCreator.createDebt());
    }

    @Test
    public void shouldReturnDebtorData() {
        //when
        String debtViewName = debtTableView.getDebtViewName();
        LocalDate debtViewDate = debtTableView.getDebtViewDate();
        BigDecimal debtAmountView = debtTableView.getDebtViewAmount();
        //then
        assertThat(debtViewName, equalTo("Fast loan"));
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