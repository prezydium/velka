package eu.sii.pl.velka.service;

import eu.sii.pl.velka.model.Debtor;

public interface  LogInDebtorService {

    AuthorisationEffect confirmThatDebtorExists(Debtor debtor);
}
