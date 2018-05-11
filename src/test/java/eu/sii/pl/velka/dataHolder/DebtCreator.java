package eu.sii.pl.velka.dataHolder;

import eu.sii.pl.velka.model.CreditCard;
import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DebtCreator {

    public static CreditCard creditCard = new CreditCard(
            "232345", "222", "Ana", "Smith", LocalDate.now());
    public static Payment payment = new Payment(1L, LocalDate.now(), new BigDecimal(30), creditCard);
    public static Payment payment1 = new Payment(1L, LocalDate.now(), new BigDecimal(130), creditCard);
    public static List<Payment> payments = new ArrayList<>(Arrays.asList(payment, payment1));

    public static Debt createDebt() {
        return new Debt(1L, "Fast loan", new BigDecimal(200), LocalDate.now(), payments);
    }

    public static Debt createDebtWithNullPayments() {
        return new Debt(1L, "Fast loan", new BigDecimal(200), LocalDate.now(), Collections.emptyList());
    }
}
