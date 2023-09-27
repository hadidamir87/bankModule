package com.example.demo.service;
/*

import com.example.demo.model.entities.AccountEntity;
import com.example.demo.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
*/

import com.example.demo.dto.CardDto;
import com.example.demo.entities.AccountEntity;
import com.example.demo.entities.CardEntity;
import com.example.demo.repositories.AccountRepository;
//import com.example.demo.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AccountService extends BaseService<AccountEntity, AccountRepository> {
    @Autowired
   private CardService cardService;
//    private final AccountRepository accountRepository;


    @Transactional
    public void insert(AccountEntity account) {

        cardService.insert(account.getCard());
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
