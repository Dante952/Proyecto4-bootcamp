package com.nttdata.pe.bankaccount.mapper;

import com.nttdata.pe.bankaccount.dto.AccountRegisterDto;
import com.nttdata.pe.bankaccount.dto.TransactionRegisterDto;
import com.nttdata.pe.bankaccount.model.Account;
import com.nttdata.pe.bankaccount.model.Transaction;
import com.nttdata.pe.bankaccount.model.TypeAccount;
import com.nttdata.pe.bankaccount.model.TypeTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    default Transaction mapRegister(TransactionRegisterDto transactionRegisterDto){
        return Transaction.builder()
                .Amount(transactionRegisterDto.getAmount())
                .typeTransaction(TypeTransaction.valueOf(transactionRegisterDto.getTypeTransaction()))
                .date(LocalDate.now())
                .build();
    }
}
