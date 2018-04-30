package eu.sii.pl.velka;

import eu.sii.pl.velka.model.Debt;
import eu.sii.pl.velka.model.Debtor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class GenerateRandomData {


    public Debtor generateDebtor(){

        Set<Debt> debtList=new HashSet<>();


      Debt debt1=new Debt(1L,new BigDecimal(3200), LocalDate.now(),null);
      Debt debt2=new Debt(2L,new BigDecimal(200), LocalDate.of(2019,12,03),null);
      Debt debt3=new Debt(3L,new BigDecimal(300), LocalDate.of(2019,10,13),null);
      Debt debt4=new Debt(4L,new BigDecimal(900), LocalDate.now(),null);
      Debt debt5=new Debt(5L,new BigDecimal(900), LocalDate.of(2019,12,03),null);
      Debt debt6=new Debt(6L,new BigDecimal(900), LocalDate.now(),null);
      Debt debt7=new Debt(7L,new BigDecimal(900), LocalDate.of(2029,12,03),null);

        debtList.add(debt1);
        debtList.add(debt2);
        debtList.add(debt3);
        debtList.add(debt4);
        debtList.add(debt5);
        debtList.add(debt6);
        debtList.add(debt7);

        return new Debtor("Wojtek", "Kowalski", "123456789", debtList);

    }
}
