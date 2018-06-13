package eu.sii.pl.velka.ui.viewfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseFactory {

    private final LoginResponse loginResponse;
    private final BalanceResponse balanceResponse;
    private final PaymentPlanResponse paymentPlanResponse;

    private Map<String, ResponseTargetI> map = new HashMap();

    @Autowired
    public ResponseFactory(LoginResponse loginResponse, BalanceResponse balanceResponse, PaymentPlanResponse paymentPlanResponse) {
        this.loginResponse = loginResponse;
        this.balanceResponse = balanceResponse;
        this.paymentPlanResponse = paymentPlanResponse;
    }

    public ResponseTargetI getResponse(String responseType) {

        ResponseTargetI response = map.get(responseType.toLowerCase());
        if (response != null) {
            return response;
        } else {
            throw new IllegalArgumentException("No such response " + responseType);
        }
    }

    @PostConstruct
    private void fillMap(){
        map.put("balance", balanceResponse);
        map.put("login", loginResponse);
        map.put("paymentplan", paymentPlanResponse);
    }
}
