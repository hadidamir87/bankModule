package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<E,R extends JpaRepository<E, String> > {
    @Autowired
    protected R repository;



}
