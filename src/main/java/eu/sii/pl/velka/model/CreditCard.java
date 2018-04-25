package eu.sii.pl.velka.model;


import java.time.LocalDate;

public class CreditCard {


    private Long id;

    private String cardId;

    private String cvv;

    private String issuingNetwork;

    private LocalDate expDate;

    public Long getId() {
        return id;
    }

    public String getCardId() {
        return cardId;
    }

    public String getCvv() {
        return cvv;
    }

    public String getIssuingNetwork() {
        return issuingNetwork;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public CreditCard() {
    }

    public CreditCard(String cardId, String cvv, String issuingNetwork, LocalDate expDate) {
        this.cardId = cardId;
        this.cvv = cvv;
        this.issuingNetwork = issuingNetwork;
        this.expDate = expDate;
    }
}
