/*
package com.example.demo.service;

import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.example.demo.dto.CustomerDto;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.repositories.CustomerRepository;
//import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerRepository> {
/*
    @Transactional
    public void insert(CustomerEntity e) {

        repository.save(e);

    }
*/

/*
    //    @Async
    public CustomerEntity findByFirstName(String name) {

        return repository.findByFirstName(name);
    }


    public CustomerEntity update(CustomerEntity c) {

        return repository.save(c);

    }

    public void deleteCustomerEntityByFirstName(String name) {
//        CustomerEntity d=repository.findByFirstName(name);
        repository.delete(repository.findByFirstName(name));
    }
    public void deleteById(String id){
        repository.deleteById(id);

    }

    public Optional<CustomerEntity> update(String id, String firstName, String surName) throws NullPointerException {
        CustomerService customerService = new CustomerService();
        Optional<CustomerEntity> customerEntity = customerService.findById(id);
        if (customerEntity.get().getFirstName() != firstName) {
            customerEntity.get().setFirstName(firstName);

        }
        if (customerEntity.get().getSurName() != surName) {
            customerEntity.get().setSurName(surName);

        }
        return customerEntity;
    }

    public Optional<CustomerEntity> findById(String id) {
        return repository.findById(id);
    }

    public void deleteCustomerById(String id)  {
//        CustomerService customerService=new CustomerService();

        repository.delete(repository.findById(id));
    }




public CustomerEntity updateSurName(String firstName) {
        CustomerEntity customerEntity=repository.findByFirstName(firstName);

        return repository.s
    }

    public CustomerEntity update(CustomerDto customerDto) {
        CustomerEntity customerEntity = repository.findById(customerDto.getId()).orElseThrow();
        BeanUtils.copyProperties(customerDto, customerEntity);
        return customerEntity;
    }

  public Optional<CustomerEntity> acquire(Long id) {
        return repository.findById(id);
    }


}
*/
