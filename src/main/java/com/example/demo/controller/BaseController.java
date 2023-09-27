package com.example.demo.controller;

import com.example.demo.dto.convertor.BaseConvertor;
import com.example.demo.service.BaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;



public abstract class BaseController<E, D, S extends BaseService<E,? extends JpaRepository<E, Long>>> {

    @Autowired
    protected S service;

    @Autowired
    protected BaseConvertor<E,D> converter;

//    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);


}
