package com.example.demo.dto;//package com.example.demo.dto;

import com.example.demo.entities.AccountEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class CustomerDto extends AbstractDto {
//    private String id ;
//    @Size(max = 5 , message = "User_Max_Size")
    private String firstName;
    private String surName;
   // private AccountEntity account;
//    private String nationalCode;
//    private Integer age;

    //    private AccountDto account ;
//    private Long balance;


}
