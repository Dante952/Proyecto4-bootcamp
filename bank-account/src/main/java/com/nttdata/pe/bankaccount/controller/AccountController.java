package com.nttdata.pe.bankaccount.controller;

import com.nttdata.pe.bankaccount.client.FeignClient;
import com.nttdata.pe.bankaccount.dto.AccountRegisterDto;
import com.nttdata.pe.bankaccount.dto.CustomerDto;
import com.nttdata.pe.bankaccount.dto.TransactionRegisterDto;
import com.nttdata.pe.bankaccount.mapper.AccountMapper;
import com.nttdata.pe.bankaccount.mapper.TransactionMapper;
import com.nttdata.pe.bankaccount.model.Account;
import com.nttdata.pe.bankaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    FeignClient feignClient;

    @PostMapping
    public ResponseEntity<Mono<Account>> register(@Valid @RequestBody AccountRegisterDto accountRegisterDto){

        Mono<Account> accountMono=feignClient.getCustomerByDni(accountRegisterDto.getPersonalCustomer()).flatMap(
                customerDto -> accountService.save(AccountMapper.INSTANCE.mapRegister(accountRegisterDto), customerDto));

        return new ResponseEntity<>(accountMono, HttpStatus.CREATED);
    }

    @PostMapping("/transaction")
    public ResponseEntity<Mono<Account>> addTransaction(@Valid @RequestBody TransactionRegisterDto transactionRegisterDto){
        return new ResponseEntity<>(accountService.saveTransaction(transactionRegisterDto.getAccountNumber(), TransactionMapper.INSTANCE.mapRegister(transactionRegisterDto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Mono<Account>> viewAccount(@RequestParam String accountNumber){
        return new ResponseEntity<>(accountService.findByAccountNumber(accountNumber),HttpStatus.OK);
    }

    @GetMapping("/customer/{dni}")
    public Mono<CustomerDto> findPersonById(@PathVariable String dni){
        return feignClient.getCustomerByDni(dni);
    }

}
