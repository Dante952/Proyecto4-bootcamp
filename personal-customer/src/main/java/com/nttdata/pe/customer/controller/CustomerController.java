package com.nttdata.pe.customer.controller;

import com.nttdata.pe.customer.dto.CustomerRegisterDto;
import com.nttdata.pe.customer.dto.CustomerUpdateDto;
import com.nttdata.pe.customer.model.Customer;
import com.nttdata.pe.customer.mapper.CustomerMapper;
import com.nttdata.pe.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Mono<Customer>> register(@Valid @RequestBody CustomerRegisterDto customerRegisterDto){
        try{
            return new ResponseEntity<>(customerService.save((CustomerMapper.INSTANCE.mapRegister(customerRegisterDto))), HttpStatus.CREATED);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(Mono.error(ex), HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("{dni}")
    public ResponseEntity<Mono<Customer>> update(@PathVariable("dni") final String dni,@Valid @RequestBody CustomerUpdateDto customerUpdateDto){
        try{
            return new ResponseEntity<>(customerService.update(dni,CustomerMapper.INSTANCE.mapUpdate(customerUpdateDto)), HttpStatus.OK);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(Mono.error(ex), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("{dni}")
    public Mono delete(@PathVariable("dni") final String dni){

        return customerService.delete(dni);
    }

    @GetMapping("{dni}")
    public Mono<Customer> findByDni(@PathVariable("dni") final String dni){
        return customerService.findByDni(dni);
    }
}
