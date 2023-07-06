package com.nttdata.pe.customer.service.impl;

import com.nttdata.pe.customer.model.Customer;
import com.nttdata.pe.customer.repository.CustomerRepository;
import com.nttdata.pe.customer.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        customer.setIsActive(Boolean.TRUE);
        return this.customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(final String dni, Customer customer) {

        return findByDni(dni).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(dbCustomer -> {
            dbCustomer.setFirstName(customer.getFirstName());
            dbCustomer.setLastName(customer.getFirstName());
            dbCustomer.setBirth(customer.getBirth());
            dbCustomer.setEmail(customer.getEmail());
            return customerRepository.save(dbCustomer);
        });
    }

    @Override
    public Mono<Customer> delete(final String dni) {
        return findByDni(dni).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(customer -> {
            customer.setIsActive(Boolean.FALSE);
            return customerRepository.save(customer);
        });
    }


    @Override
    public Mono<Customer> findByDni(String dni) {
        return this.customerRepository.findFirstByDni(dni);
    }


}
