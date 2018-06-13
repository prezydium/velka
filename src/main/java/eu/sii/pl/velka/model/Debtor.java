package eu.sii.pl.velka.model;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@SpringComponent
@UIScope
public class Debtor implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String ssn;

    private List<Debt> debts = Collections.EMPTY_LIST;

    public Debtor() {
    }

    public Debtor(String firstName, String lastName, String ssn, List<Debt> debts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.debts = debts;
    }

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

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Debtor{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", ssn='").append(ssn).append('\'');
        sb.append(", debts=").append(debts);
        sb.append('}');
        return sb.toString();
    }
}