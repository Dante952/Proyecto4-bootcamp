package com.nttdata.pe.bankaccount.dto;

import com.nttdata.pe.bankaccount.model.TypeTransaction;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Data
public class TransactionRegisterDto {

    @NotEmpty(message = "{NotEmpty.customer.accountNumber}")

    private String accountNumber;
    @NotEmpty(message = "{NotEmpty.customer.accountNumber}")
    @Pattern(regexp = "(WITHDRAW)|(DEPOSIT)", message = "{Pattern.customer.accountNumber}")
    private String typeTransaction;
    private Double amount;



}
