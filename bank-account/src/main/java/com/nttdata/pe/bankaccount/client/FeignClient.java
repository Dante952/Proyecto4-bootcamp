package com.nttdata.pe.bankaccount.client;

import com.nttdata.pe.bankaccount.dto.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient (url = "http://localhost:8082/customer", name= "personal-customer")
public interface FeignClient {
    @GetMapping("/{dni}")
    Mono<CustomerDto> getCustomerByDni(@RequestParam (value = "dni") String dni);

}
