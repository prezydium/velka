package eu.sii.pl.velka.model;

import java.util.Collections;
import java.util.List;


public class Debtor {

    private Long id;

    private String firstName;

    private String lastName;

    private String ssn;

    private List<Debt> listOfDebts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<Debt> getListOfDebts() {
        return Collections.unmodifiableList(listOfDebts);
    }

    public void setListOfDebts(List<Debt> listOfDebts) {
        this.listOfDebts = Collections.unmodifiableList(listOfDebts);
    }

    public Debtor(String firstName, String lastName, String ssn, List<Debt> setOfDebts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.listOfDebts = setOfDebts;
    }

    public Debtor() {
    }

    @Override
    public String toString() {
        return "Debtor{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", surname='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", debts=" + +
                '}';
    }
}
