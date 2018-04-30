package eu.sii.pl.velka.model;

import java.util.HashSet;
import java.util.Set;


public class Debtor {

    private Long id;

    private String firstName;

    private String lastName;

    private String ssn;

    private Set<Debt> setOfDebts;


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public Set<Debt> getDebts() {
        return new HashSet<>(setOfDebts);
    }

    public void setDebts(Set<Debt> debts) {
        this.setOfDebts = debts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String name) {
        this.firstName= name;
    }

    public void setlastname(String lastName) {
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


    public Debtor( String firstName,String lastName, String ssn, Set<Debt> setOfDebts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.setOfDebts = new HashSet<>(setOfDebts);
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
                ", debts=" + setOfDebts +
                '}';
    }
}
