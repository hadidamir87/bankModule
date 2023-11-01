package com.example.demo.model.dto;//package com.example.demo.dto;

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
    private String firstName;
    private String surName;
    private Long nationalCode;
    private Long phoneNumber;
//    private AccountEntity account;
//    private String nationalCode;
//    private Integer age;

    //    private AccountDto account ;
//    private Long balance;


}
