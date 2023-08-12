package com.example.demo.controller;
/*
import com.example.demo.dto.convertor.CustomerDto;
import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;*/

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entities.AccountEntity;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.service.AccountService;
import com.example.demo.service.CustomerService;
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

        service.insert(converter.convertToE(a));
    }

    @GetMapping("/get/{account_number}")
//    @Transactional
    public AccountDto findByAccountNumber(@PathVariable Long account_number) {

        return converter.convertToDto(service.findByAccountN(account_number));
    }

    @DeleteMapping("/{account_number}")
    public void deleteByAccountNum(@PathVariable Long account_number) {

       AccountDto accountDto= converter.convertToDto(service.findByAccountN(account_number));
        service.deleteByAccountN(converter.convertToE(accountDto));
    }
}
