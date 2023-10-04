package com.example.demo.dto.convertor;

import org.mapstruct.Mapper;


import com.example.demo.dto.CustomerDto;
import com.example.demo.entities.CustomerEntity;


@Mapper(componentModel = "spring")

public interface CustomerConvertor extends BaseConvertor<CustomerEntity,CustomerDto>{

}
