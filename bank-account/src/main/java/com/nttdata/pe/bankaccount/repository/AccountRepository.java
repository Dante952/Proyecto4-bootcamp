package com.nttdata.pe.bankaccount.repository;

import com.nttdata.pe.bankaccount.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account,String> {
    Mono<Account> findFirstByAccountNumber(String accountNumber);
}
