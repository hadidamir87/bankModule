package com.example.demo.service;
/*

import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
*/

import com.example.demo.dto.AccountDto;
import com.example.demo.entities.AccountEntity;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.repositories.CustomerRepository;
//import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerRepository> {

    @Transactional
    public void insert(CustomerEntity e) {

        repository.save(e);

    }

    //    @Async
    public CustomerEntity findByFirstName(String name) {

        return repository.findByFirstName(name);
    }

    public void deleteCustomerEntityByFirstName(String name) {
//        CustomerEntity d=repository.findByFirstName(name);
        repository.delete(repository.findByFirstName(name));
    }
/*

    public AccountEntity updateSurName(String firstName) {
        CustomerEntity customerEntity=repository.findByFirstName(firstName);

        return repository.s
    }
*/

  /*  public Optional<CustomerEntity> acquire(Long id) {
        return repository.findById(id);
    }*/

  /*  public CustomerEntity findById(Long id) {
        return repository.findById(id);
    }*/
}
