package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debtor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class GetFullDataDebtorControllerTest {

    @Autowired
    GetFullDataDebtorController getFullDataDebtorController;

    @Test
    public void shouldCallApiForFullData() throws Exception {
      //GetFullDataDebtorController getFullDataDebtorController = new GetFullDataDebtorController();
       Debtor debtor = getFullDataDebtorController.getFullData("980-122-111");
       Assertions.assertThat(!debtor.getDebts().isEmpty());
    }

}