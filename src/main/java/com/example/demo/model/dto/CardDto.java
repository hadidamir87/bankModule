package com.example.demo.model.dto;

import com.example.demo.model.entities.AccountEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CardDto extends AbstractDto{
//    private Integer cvv2;
//    private LocalDateTime expireDate;
    private Long cardNumber;
//    private AccountEntity account;


}
