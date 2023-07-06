package com.nttdata.pe.customer.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class CustomerRegisterDto {

    @NotEmpty(message = "{NotEmpty.customer.dni}")
    @Pattern(regexp = "[1-9][0-9]{7}", message = "{Pattern.customer.dni}")
    private String dni;

    @NotEmpty(message = "{NotEmpty.customer.firstName}")
    @Pattern(regexp = "[a-zA-Z]{2,20}", message = "{Pattern.customer.firstName}")
    private String firstName;

    @NotEmpty(message = "{NotEmpty.customer.lastName}")
    @Pattern(regexp = "[a-zA-Z]{2,20}", message = "{Pattern.customer.lastName}")
    private String lastName;

    @NotEmpty(message = "{NotEmpty.customer.email}")
    @Email(message = "{Email.customer.email}")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
}
