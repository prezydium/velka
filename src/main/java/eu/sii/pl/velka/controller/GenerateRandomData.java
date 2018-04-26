package eu.sii.pl.velka.controller;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import eu.sii.pl.velka.model.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateRandomData {


    public Debtor generateDebtor(){
        List<Payment> paymentList= new ArrayList<>();
        List<Debt> debtList=new ArrayList<>();
       // paymentList.add(new Payment(1,LocalDate.now(),new BigDecimal(200),null,null));



      Debt debt1=new Debt(1L,new BigDecimal(3200), LocalDate.now(),null);
      Debt debt2=new Debt(2L,new BigDecimal(200), LocalDate.now(),null);
      Debt debt3=new Debt(3L,new BigDecimal(300), LocalDate.now(),null);
      Debt debt4=new Debt(4L,new BigDecimal(900), LocalDate.now(),null);

        debtList.add(debt1);
        debtList.add(debt2);
        debtList.add(debt3);
        debtList.add(debt4);

        return new Debtor("Wojtek", "Kowalski", "123456789", debtList);

    }
}
