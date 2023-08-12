package com.example.demo.dto;


import lombok.*;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto extends AbstractDto{
//    private AccountType accountType;
    private Long accountNumber;
    private Integer cvv2;

//    private Long balance;
//    private CustomerDto customer;
//    private CardDto card;
//    private List<TransactionDto> transactions;
}
