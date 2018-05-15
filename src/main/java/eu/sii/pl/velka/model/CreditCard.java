package eu.sii.pl.velka.model;


import java.time.LocalDate;

public class CreditCard {

    private Long id;

    private String ccNumber;

    private String cvv;

    private String issuingNetwork;

    private String firstName;

    private String lastName;


    private LocalDate expDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public CreditCard() {
    }

    public CreditCard(String ccNumber, String cvv, String firstName, String lastName, LocalDate expDate) {
        this.ccNumber = ccNumber;
        this.cvv = cvv;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expDate=expDate;

    }
}
