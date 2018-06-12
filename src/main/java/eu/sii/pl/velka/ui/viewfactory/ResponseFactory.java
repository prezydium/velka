package eu.sii.pl.velka.ui.viewfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseFactory {

    @Autowired
    private LoginResponse loginResponse;
    @Autowired
    private BalanceResponse balanceResponse;
    @Autowired
    private PaymentPlanResponse paymentPlanResponse;

    private Map<String, ResponseTargetI> map = new HashMap();

    public ResponseTargetI getResponse(String responseType) {
        map.put("balance", balanceResponse);
        map.put("login", loginResponse);
        map.put("paymentplan", paymentPlanResponse);
        ResponseTargetI response = map.get(responseType.toLowerCase());
        if (response != null) {
            return response;
        } else {
            throw new IllegalArgumentException("No such response " + responseType);
        }
    }
}
