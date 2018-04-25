package eu.sii.pl.velka.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

    public Debtor() {
    }

    public Debtor(String name, String surname, String ssn, List<Debt> debts) {
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.debts = debts;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Debtor{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", ssn='").append(ssn).append('\'');
        sb.append(", debts=").append(debts);
        sb.append('}');
        return sb.toString();
    }
}
