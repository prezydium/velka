package eu.sii.pl.velka.dataHolder;

import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DebtorCreator {



    public Debtor createDebtor() {

        CreditCard creditCard = new CreditCard(
                "232345", "222", "Ana", "Smith");
        Payment payment = new Payment(1L, LocalDate.now(), new BigDecimal(30), creditCard);
        Payment payment1 = new Payment(1L, LocalDate.now(), new BigDecimal(130), creditCard);
        List<Payment> payments = new ArrayList<>(Arrays.asList(payment, payment1));
        Debt debt = new Debt(1L, new BigDecimal(200), LocalDate.now(), payments);
        Debt debt1 = new Debt(1L, new BigDecimal(400), LocalDate.now(), payments);
        List<Debt> debts = new ArrayList<>(Arrays.asList(debt, debt1));
         return new Debtor("Ana", "Smith", "232122333", debts);
    }
}
