package com.example.demo.model.dto.convertor;//package com.example.demo.model.convertor;


import org.hibernate.service.spi.ServiceException;

import java.util.List;
import java.util.stream.Collectors;



public interface BaseConvertor<E, D> {

    E convertToE(D dto);

    D convertToDto(E entity);

    default List<E> collectionConvertorToEntity(List<D> dList) {
        if (dList != null) {
            return dList.stream().map(i -> {
                try {
                    return convertToE(i);
                } catch (ServiceException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());

        }
        return null;
    }

    default List<D> collectionConvertorToDto(List<E> eList) {
        if (eList != null) {
            return eList.stream()
                    .map(i -> convertToDto(i))
                            .collect(Collectors.toList());
        }
        return null;
    }
}
