package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.Debtor;

import java.util.Optional;

public interface BalanceService {
    Debtor getFullData(String ssn);
}
