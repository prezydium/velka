package eu.sii.pl.velka.model;

import java.util.List;


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
        return "Debtor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ssn='" + ssn + '\'' +
                ", debts=" + debts +
                '}';
    }
}
