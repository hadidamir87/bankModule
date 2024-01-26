package com.example.demo.model.dto.convertor;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.role.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserConvertor extends BaseConvertor<UserEntity, UserDto>{
}
