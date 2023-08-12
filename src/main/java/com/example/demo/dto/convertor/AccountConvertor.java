package com.example.demo.dto.convertor;
/*
import com.example.demo.dto.convertor.AccountDto;
import com.example.demo.model.entities.AccountEntity;
import org.mapstruct.Mapper;*/

import com.example.demo.dto.AccountDto;
import com.example.demo.entities.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AccountConvertor extends BaseConvertor<AccountEntity,AccountDto> {

}
