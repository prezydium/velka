package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateRandomData {


    public Debtor generateDebtor(){

        List<Debt> debtList=new ArrayList<>();
        debtList.add(new Debt(1L,new BigDecimal(3200), LocalDate.now(),null));
        debtList.add(new Debt(2L,new BigDecimal(200), LocalDate.now(),null));
        debtList.add(new Debt(3L,new BigDecimal(300), LocalDate.now(),null));
        debtList.add(new Debt(4L,new BigDecimal(900), LocalDate.now(),null));

        return new Debtor("Wojtek", "Kowalski", "123456789", debtList);

    }
}
