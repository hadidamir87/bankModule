package com.example.demo.model.dto.convertor;

import com.example.demo.model.entities.CustomerEntity;
import org.mapstruct.Mapper;


import com.example.demo.model.dto.CustomerDto;


@Mapper(componentModel = "spring")

public interface CustomerConvertor extends BaseConvertor<CustomerEntity,CustomerDto>{

}
