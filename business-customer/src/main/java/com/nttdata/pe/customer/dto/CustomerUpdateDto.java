package com.nttdata.pe.customer.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class CustomerUpdateDto {

    @NotEmpty(message = "{NotEmpty.customer.firstName}")
    @Pattern(regexp = "[a-zA-Z]{2,20}", message = "{Pattern.customer.firstName}")
    private String businessName;

    @NotEmpty(message = "{NotEmpty.customer.email}")
    @Email(message = "{Email.customer.email}")
    private String email;

}
