package com.nttdata.pe.bankaccount.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class Transaction {
    private TypeTransaction typeTransaction;
    private Double Amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss+HH:mm")
    private LocalDate date;

}
