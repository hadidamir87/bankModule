package com.example.demo.dto.convertor;//package com.example.demo.model.convertor;

public interface BaseConvertor<E,D>{

 E convertToE(D dto);

 D convertToDto(E entity);
}
