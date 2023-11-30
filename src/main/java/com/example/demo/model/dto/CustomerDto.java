package com.example.demo.model.dto;//package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerDto extends AbstractDto {
    //    private String id ;
//    @Size(max = 5 , message = "User_Max_Size")
    private Long id;
    @Pattern(regexp = "^[A-Za-z\\s]+$")
    private String firstName;
    private String surName;
//    @NotNull(message = "First name is required")
    @Pattern(regexp = "^\\d{10}$",message = "شماره ملی باید10 رقم باشد.")
    private String nationalCode;
//    @Pattern(regexp = "^09[0|1|2|3][0-9]{8}$")
    private Long phoneNumber;
//    private AccountEntity account;
//    private String nationalCode;
//    private Integer age;

    //    private AccountDto account ;
//    private Long balance;


}
