package eu.sii.pl.velka.model;


import java.time.LocalDate;

public class CreditCard {


    private Long id;

    private String CCNumber;

    private String cvv;

    private String firstName;

    private String lastName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCCNumber() {
        return CCNumber;
    }

    public void setCCNumber(String CCNumber) {
        this.CCNumber = CCNumber;
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

    public CreditCard() {
    }

    public CreditCard(String ccNumber, String cvv, String firstName, String lastName) {
        this.CCNumber = ccNumber;
        this.cvv = cvv;
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
