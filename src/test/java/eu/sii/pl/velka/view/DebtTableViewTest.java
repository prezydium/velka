package eu.sii.pl.velka.view;

import eu.sii.pl.velka.dataHolder.DebtCreator;
import eu.sii.pl.velka.view.viewModel.DebtTableView;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        Long debtViewId = debtTableView.getDebtViewId();
        LocalDate debtViewDate = debtTableView.getDebtViewDate();
        BigDecimal debtAmountView = debtTableView.getDebtViewAmount();
        //then
        Assert.assertThat(debtViewId, CoreMatchers.equalTo(1L));
        Assert.assertThat(debtViewDate, CoreMatchers.equalTo(LocalDate.now()));
        Assert.assertThat(debtAmountView, CoreMatchers.equalTo(new BigDecimal(200)));
    }

    @Test
    public void shouldReturnRemainAmount() {
        //when
        BigDecimal remainAmount = debtTableView.getRemainingAmountView();
        //then
        Assert.assertThat(remainAmount, CoreMatchers.equalTo(new BigDecimal(40).setScale(2)));
    }
}
