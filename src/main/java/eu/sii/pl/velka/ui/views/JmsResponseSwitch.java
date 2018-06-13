package eu.sii.pl.velka.ui.views;

import eu.sii.pl.velka.ui.authorisation.SuccessfulLoginView;

import java.util.HashMap;
import java.util.Map;

public class JmsResponseSwitch {

    public static Map<String, String> fillMap() {
        Map<String, String> map = new HashMap<>();
        map.put("login", SuccessfulLoginView.VIEW_NAME);
        map.put("balance", BalanceView.VIEW_NAME);
        map.put("paymentplan", PaymentPlanView.VIEW_NAME);
        map.put("paymentsupdate", SuccessfulPaymentView.VIEW_NAME);
        return map;
    }
}
