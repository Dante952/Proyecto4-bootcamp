package com.nttdata.pe.bankaccount.mapper;

import com.nttdata.pe.bankaccount.dto.AccountRegisterDto;
import com.nttdata.pe.bankaccount.dto.TransactionRegisterDto;
import com.nttdata.pe.bankaccount.model.Account;
import com.nttdata.pe.bankaccount.model.Transaction;
import com.nttdata.pe.bankaccount.model.TypeAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    default Account mapRegister(AccountRegisterDto accountRegisterDto){
        return Account.builder()
                .personalCustomer(accountRegisterDto.getPersonalCustomer())
                .amount(accountRegisterDto.getAmount())
                .typeAccount(TypeAccount.valueOf(accountRegisterDto.getTypeAccount()))
                .transactions(new ArrayList<>())
                .build();
    }





}
