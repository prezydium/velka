package eu.sii.pl.velka.model;

import java.util.Collections;
import java.util.List;

import java.util.*;

@SpringComponent
@UIScope
public class Debtor {

    private Long id;

    private String name;

    private String surname;

    private String ssn;

    private List<Debt> debts;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSsn() {
        return ssn;
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
