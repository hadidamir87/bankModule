package com.example.demo.controller;
/*
import com.example.demo.dto.convertor.CustomerDto;
import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;*/

import com.example.demo.model.dto.AccountDto;
import com.example.demo.model.entities.AccountEntity;
//import com.example.demo.entities.CustomerEntity;
import com.example.demo.service.AccountService;
//import com.example.demo.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")

public class AccountController extends BaseController<AccountEntity, AccountDto, AccountService> {
//    @RequestMapping("/account")

    @PostMapping("/createAccount")
//    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void add(@RequestBody AccountDto a) {
//        AccountEntity accountForGettingCardNumber = converter.convertToE(a);
//        accountForGettingCardNumber.getCard().setCardNumber(a.getCardNumber());
//        converter.convertToE(a).getCard().setCardNumber();


        service.insert(converter.convertToE(a));
//        service.insert(accountForGettingCardNumber);
    }

    @GetMapping("/get/{account_number}")
//    @Transactional
    public AccountDto findByAccountNumber(@PathVariable Long account_number) {

        return converter.convertToDto(service.findByAccountN(account_number));
    }

    @DeleteMapping("{account_number}")
    public void deleteByAccount(Long an) {
        service.deleteByAccountN(an);
    }

}
