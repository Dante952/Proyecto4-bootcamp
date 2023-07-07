package com.nttdata.pe.bankaccount.service.impl;

import com.nttdata.pe.bankaccount.dto.CustomerDto;
import com.nttdata.pe.bankaccount.model.Account;
import com.nttdata.pe.bankaccount.model.Transaction;
import com.nttdata.pe.bankaccount.model.TypeAccount;
import com.nttdata.pe.bankaccount.repository.AccountRepository;
import com.nttdata.pe.bankaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Flux<Account> getAll() {
        return this.accountRepository.findAll();
    }

    @Override

    public Mono<Account> save(Account account, CustomerDto customerDto) {
        if(account.getTypeAccount().equals(TypeAccount.SAVINGS)){
            account.setAccountNumber("SAV"+customerDto.getDni());
        }else{
            account.setAccountNumber("CUR"+customerDto.getDni());
        }
        account.setPersonalCustomer(customerDto);
        return this.accountRepository.save(account);
    }

    @Override
    public Mono<Account> update(String dni, Account account) {
        return null;
    }

    @Override
    public Mono<Account> delete(String id) {
        return null;
    }

    @Override
    public Mono<Account> findByAccountNumber(String accountNumber) {
        return this.accountRepository.findFirstByAccountNumber(accountNumber);
    }

    @Override
    public Mono<Account> saveTransaction(String accountNumber, Transaction transaction) {

        return findByAccountNumber(accountNumber).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(
                account -> {
                    account.getTransactions().add(transaction);
                    return this.accountRepository.save(account);
                }
        );
    }
}
