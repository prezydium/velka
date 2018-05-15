package eu.sii.pl.velka.dataHolder;

import eu.sii.pl.velka.model.PaymentPlan;
import eu.sii.pl.velka.model.PlannedPayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaymentPlanCreator {


    public static PaymentPlan createPaymentPlan() {
        PlannedPayment plannedPayment=new PlannedPayment("999888777666", new BigDecimal("10"));
        PlannedPayment plannedPayment1=new PlannedPayment("999888777666", new BigDecimal("100"));
        List<PlannedPayment> listOfPlannedPayment= new  ArrayList<>(Arrays.asList(plannedPayment,plannedPayment1));
        return new PaymentPlan("message", "980-122-111",  listOfPlannedPayment);
    }
}
