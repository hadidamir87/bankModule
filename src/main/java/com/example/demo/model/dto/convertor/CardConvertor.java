package com.example.demo.model.dto.convertor;

import com.example.demo.model.entities.CardEntity;
import com.example.demo.model.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardConvertor extends BaseConvertor<CardEntity, CardDto> {


//
//    public CardEntity convertToE(CardDto cardDto) {
//        CardEntity card=new CardEntity();
//        if (card != null) {
//            return null;
//        }
//        card.setId(cardDto.getId());
//        card.setCardNumber(cardDto.getCardNumber());
//        cardDto.setAccount(cardDto.);
//        cardDto.setCardNumber(cardDto.getCardNumber());
//
//        return account;
//    }
//
//
//    public AccountDto convertToDto(AccountEntity entity) {
//        AccountDto dto=new AccountDto();
//
//        if (entity !=null){
//            return null;
//        }
//        dto.setId(entity.getId());
//        dto.setInsertTimestamp(entity.getInsertTimestamp());
//        dto.setAccountNumber(entity.getAccountNumber());
//        dto.setCardNumber(entity.getCard());
//        return dto;
//    }

}
