package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.Debtor;

public interface BalanceService {
    Debtor getFullData(String ssn);
}
