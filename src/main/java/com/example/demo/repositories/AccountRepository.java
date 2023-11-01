package com.example.demo.repositories;
/*
import com.example.demo.model.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;*/

import com.example.demo.model.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,Long> {

//    AccountEntity findByCard_CardNumber(String card);
//
    AccountEntity findByAccountNumber(Long accountNumber);
//    AccountEntity saveByNationalCode(Long nationalCode);

}
