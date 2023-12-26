package com.example.demo.controller;

import com.example.demo.model.dto.convertor.BaseConvertor;
import com.example.demo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract class BaseController<E, D, S extends BaseService<E, ? extends JpaRepository<E, Long>>> {

    protected static final Logger LOGGER= LoggerFactory.getLogger(BaseController.class);
    @Autowired
    protected S service;

    @Autowired
    protected BaseConvertor<E, D> converter;

//    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);


}
