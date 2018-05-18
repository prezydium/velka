package eu.sii.pl.velka.model;

public class PaymentConfirmation {

    private final String clientId = "Velka";

    private PaymentDeclaration paymentDeclaration;

    private CreditCard creditCard;

    public PaymentDeclaration getPaymentDeclaration() {
        return paymentDeclaration;
    }

    public void setPaymentDeclaration(PaymentDeclaration paymentDeclaration) {
        this.paymentDeclaration = paymentDeclaration;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public PaymentConfirmation(PaymentDeclaration paymentDeclaration, CreditCard creditCard) {
        this.paymentDeclaration = paymentDeclaration;
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PaymentConfirmation{");
        sb.append("paymentDeclaration=").append(paymentDeclaration);
        sb.append(", creditCard=").append(creditCard);
        sb.append('}');
        return sb.toString();
    }
}
