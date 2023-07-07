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
                .ruc(customerRegisterDto.getRuc())
                .businnesName(customerRegisterDto.getBusinessName())
                .email(customerRegisterDto.getEmail())
                .isVIP(Boolean.FALSE)
                .isActive(Boolean.TRUE)
                .build();
    }

    default Customer mapUpdate(CustomerUpdateDto customerUpdateDto){
        return Customer.builder()
                .businnesName(customerUpdateDto.getBusinessName())
                .email(customerUpdateDto.getEmail())
                .build();
    }
}
