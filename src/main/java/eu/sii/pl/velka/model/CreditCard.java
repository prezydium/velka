package eu.sii.pl.velka.model;


import java.time.LocalDate;

public class CreditCard {


    private Long id;

    private String CCNumber;

    private String cvv;

    private String firstName;

    private String lastName;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Long getId() {
        return id;
    }

    public String getCvv() {
        return cvv;
    }

    public String getFirstName() {
        return firstName;
    }


    public CreditCard() {
    }

    public CreditCard(String ccNumber, String cvv, String firstName,String lastName) {
        this.CCNumber = ccNumber;
        this.cvv = cvv;
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
