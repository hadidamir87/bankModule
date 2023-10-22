package com.example.demo.repositories;

import com.example.demo.entities.CustomerEntity;
//import com.example.demo.model.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;



//import com.example.demo.entities.CustomerEntity;


import java.util.Optional;
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

//    CustomerEntity findByAccounts(Long id);
//    CustomerEntity findByFirstName(String name);


//    void delete(Optional<CustomerEntity> byId);
//    CustomerEntity deleteCustomerEntityByFirstName(String name);
//    CustomerEntity findByFirstNameLike(String name);
//    CustomerEntity findById(String id);
    Boolean existsByNationalCode(Long nationalCode);


}

