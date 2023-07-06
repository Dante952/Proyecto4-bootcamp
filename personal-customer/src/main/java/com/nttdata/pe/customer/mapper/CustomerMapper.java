package com.nttdata.pe.customer.mapper;

import com.nttdata.pe.customer.dto.CustomerRegisterDto;
import com.nttdata.pe.customer.dto.CustomerUpdateDto;
import com.nttdata.pe.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    default Customer mapRegister(CustomerRegisterDto customerRegisterDto){
        return Customer.builder()
                .dni(customerRegisterDto.getDni())
                .firstName(customerRegisterDto.getFirstName())
                .lastName(customerRegisterDto.getLastName())
                .birth(customerRegisterDto.getBirth())
                .email(customerRegisterDto.getEmail())
                .isVIP(Boolean.FALSE)
                .isActive(Boolean.TRUE)
                .build();
    }

    default Customer mapUpdate(CustomerUpdateDto customerUpdateDto){
        return Customer.builder()
                .firstName(customerUpdateDto.getFirstName())
                .lastName(customerUpdateDto.getLastName())
                .birth(customerUpdateDto.getBirth())
                .email(customerUpdateDto.getEmail())
                .build();
    }
}
