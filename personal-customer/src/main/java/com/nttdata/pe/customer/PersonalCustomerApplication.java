package com.nttdata.pe.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PersonalCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalCustomerApplication.class, args);
	}

}
