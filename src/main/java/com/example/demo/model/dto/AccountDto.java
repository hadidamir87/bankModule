package com.example.demo.model.dto;


//import com.example.demo.entities.CustomerEntity;
import lombok.*;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AccountDto extends AbstractDto{
//    private AccountType accountType;
    private Long accountNumber;
    private CardDto card;

//    private String customer_id;
//    private Long balance;
//    private CardDto card;
//    private List<TransactionDto> transactions;
}
