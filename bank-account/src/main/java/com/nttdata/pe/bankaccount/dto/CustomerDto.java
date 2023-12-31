package com.nttdata.pe.bankaccount.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@JsonAutoDetect (fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class CustomerDto {

    private String dni;

    private String firstName;

    private String lastName;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    private Boolean isVIP;
    private Boolean isActive;
}
