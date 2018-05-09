package eu.sii.pl.velka.UI.viewModel;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import eu.sii.pl.velka.model.PaymentDeclaration;
import java.math.BigDecimal;

@SpringComponent
@UIScope
public class PaymentFormView {

    private String debtUuid;
    private String ssn;
    private String paymentAmount;

    public String getDebtUuid() {
        return debtUuid;
    }

    public void setDebtUuid(String debtUuid) {
        this.debtUuid = debtUuid;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentFormView() {
    }

    public PaymentDeclaration maptoPaymentDeclaration(){
              return new PaymentDeclaration(new BigDecimal(this.paymentAmount),this.debtUuid,this.ssn);
    }

}
