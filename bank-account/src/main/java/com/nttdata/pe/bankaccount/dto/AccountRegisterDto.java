package com.nttdata.pe.bankaccount.dto;

import com.nttdata.pe.bankaccount.model.Transaction;
import com.nttdata.pe.bankaccount.model.TypeAccount;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class AccountRegisterDto {

    @NotEmpty(message = "{NotEmpty.account.dni}")
    @Pattern(regexp = "[1-9][0-9]{7}", message = "{Pattern.customer.dni}")
    private String personalCustomer;

    private Double amount;

    @NotEmpty(message = "{NotEmpty.customer.amount}")
    @Pattern(regexp = "(CURRENT)|(SAVINGS)", message = "{Pattern.customer.accountNumber}")
    private String typeAccount;

}
