package com.example.demo.repositories;
/*

import com.example.demo.model.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
*/

import com.example.demo.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {

//    CustomerEntity findByAccounts(Long id);
    CustomerEntity findByFirstName(String name);
//    CustomerEntity deleteCustomerEntityByFirstName(String name);
//    CustomerEntity findByFirstNameLike(String name);

}
