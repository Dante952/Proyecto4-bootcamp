package com.nttdata.pe.bankaccount.service;

import com.nttdata.pe.bankaccount.dto.CustomerDto;
import com.nttdata.pe.bankaccount.model.Account;
import com.nttdata.pe.bankaccount.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    Flux<Account> getAll();
    Mono<Account> save(Account account , CustomerDto customerDto);

    Mono<Account> update(final String dni, Account account);

    Mono<Account> delete(final String id);

    Mono<Account> findByAccountNumber(String accountNumber);

    Mono<Account> saveTransaction(final String accountNumber, Transaction transaction);
}
