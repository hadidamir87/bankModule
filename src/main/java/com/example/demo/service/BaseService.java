package com.example.demo.service;


import com.example.demo.exceptionHandller.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<E, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;


    public void add(E e) throws ServiceException {
        repository.save(e);
    }


}
