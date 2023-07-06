package com.nttdata.pe.customer.service;

import com.nttdata.pe.customer.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<Customer> getAll();
    Mono<Customer> save(Customer customer);

    Mono<Customer> update(final String dni, Customer customer);

    Mono<Customer> delete(final String id);

    Mono<Customer> findByDni(String dni);

}
