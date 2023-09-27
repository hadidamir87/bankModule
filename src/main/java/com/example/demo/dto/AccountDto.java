package com.example.demo.dto;


//import com.example.demo.entities.CustomerEntity;
import com.example.demo.entities.CardEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto extends AbstractDto{
//    private AccountType accountType;
    private Long accountNumber;
    private CardDto card;

//    private String customer_id;
//    private Long balance;
//    private CardDto card;
//    private List<TransactionDto> transactions;
}
