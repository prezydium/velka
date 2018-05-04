package eu.sii.pl.velka.dataHolder;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static eu.sii.pl.velka.dataHolder.DebtCreator.payments;

public class DebtorCreator {

    public static Debtor createDebtor() {
        Debt debt = new Debt(1L, "Fast loan",new BigDecimal(200), LocalDate.now(), payments);
        Debt debt1 = new Debt(1L,"Fast loan", new BigDecimal(400), LocalDate.now(), payments);
        List<Debt> debts = new ArrayList<>(Arrays.asList(debt, debt1));
        return new Debtor("Ana", "Smith", "232122333", debts);
    }
}
