package com.example.demo.service;
/*

import com.example.demo.model.entities.AccountEntity;
import com.example.demo.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
*/

import com.example.demo.entities.AccountEntity;
import com.example.demo.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AccountService extends BaseService<AccountEntity, AccountRepository> {

    @Transactional
    public void insert(AccountEntity account) {

        repository.save(account);
    }

    public AccountEntity findByAccountN(Long account) {
//     AccountEntity accountEntity=new AccountEntity();
        return repository.findByAccountNumber(account);
    }

    public void deleteByAccountN(AccountEntity account){
        repository.delete(account);
    }
}
