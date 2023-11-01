package com.example.demo.service;
/*

import com.example.demo.model.entities.AccountEntity;
import com.example.demo.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
*/

import com.example.demo.model.entities.AccountEntity;
import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.repositories.AccountRepository;
//import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService extends BaseService<AccountEntity, AccountRepository> {

    @Autowired
    private CustomerEntity customer;
//    private final AccountRepository accountRepository;


    @Transactional
    public void insert(AccountEntity account) {
//        account.setAccountNumber(customer.getNationalCode()/10000);

//        cardService.insert(account.getCards().get(account.getVersion()));
// It was for the time that we had oneToOne relationship between account and card.

        repository.save(account);

    }

    public AccountEntity findByAccountN(Long accountNumber) {
//     AccountEntity accountEntity=new AccountEntity();
        return repository.findByAccountNumber(accountNumber);

    }

    public void deleteByAccountN(Long accountNumber) {
        AccountEntity account = repository.findByAccountNumber(accountNumber);
        repository.delete(account);
    }

}
