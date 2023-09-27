package com.example.demo.dto;

import com.example.demo.entities.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDto extends AbstractDto{
//    private Integer cvv2;
//    private LocalDateTime expireDate;
    private Long cardNumber;
    private AccountEntity account;


}
