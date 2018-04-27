package eu.sii.pl.velka.model;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Debtor {

    private Long id;

    private String firstName;

    private String lastName;

    private String ssn;

    private Set<Debt> debts;

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
        return debts;
    }

    public void setDebts(Set<Debt> debts) {
        this.debts = Collections.unmodifiableSet(debts);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Debtor() {
    }

    public Debtor(String firstName, String lastName, String ssn, Set<Debt> debts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.debts = Collections.unmodifiableSet(debts);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Debtor{");
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", ssn='").append(ssn).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
