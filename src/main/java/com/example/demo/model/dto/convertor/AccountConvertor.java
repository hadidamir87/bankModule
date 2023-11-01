package com.example.demo.model.dto.convertor;
/*
import com.example.demo.dto.convertor.AccountDto;
import com.example.demo.model.entities.AccountEntity;
import org.mapstruct.Mapper;*/

import com.example.demo.model.entities.AccountEntity;
import com.example.demo.model.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AccountConvertor extends BaseConvertor<AccountEntity, AccountDto> {


//
//    public AccountEntity convertToE(AccountDto dto) {
//        AccountEntity account=new AccountEntity();
//        if (dto != null) {
//            return null;
//        }
//        account.setId(dto.getId());
//        account.setInsertTimestamp(dto.getInsertTimestamp());
//        account.setAccountNumber(dto.getAccountNumber());
//        account.setCard(dto.getCardNumber());
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
