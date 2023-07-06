package com.nttdata.pe.customer.repository;

import com.nttdata.pe.customer.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {
    Mono<Customer> findFirstByDni(String dni);
}
