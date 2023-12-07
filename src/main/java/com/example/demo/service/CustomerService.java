package com.example.demo.service;

import com.example.demo.model.entities.AccountEntity;
import com.example.demo.model.entities.CardEntity;
//import com.example.demo.exceptionHandller.exceptions.IdNotFoundException;
import com.example.demo.exceptionHandller.exceptions.ServiceException;
import com.example.demo.exceptionHandller.exceptions.handledExceptions.DuplicateCustomerEntry;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.model.dto.CustomerDto;
import com.example.demo.model.entities.CustomerEntity;
//import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
//@Valid
public class CustomerService extends BaseService<CustomerEntity, CustomerRepository> {
    @Autowired
    private CardService cardService;

    @Autowired
    private AccountService accountService;

    @Transactional
    public void insert(CustomerEntity customer) throws ServiceException {

        if (repository.existsByNationalCode(customer.getNationalCode())) {
            throw new DuplicateCustomerEntry("duplicateStudentNew");
        }
        if (customer.getNationalCode() == null) {
            throw new DuplicateCustomerEntry("nationalCodeIsNecessary");
        }

        if (customer.getPhoneNumber() == null) {
            throw new DuplicateCustomerEntry("phoneNumberIsNecessary");
        }

        AccountEntity account = new AccountEntity();
        account.setAccountNumber(customer.getNationalCode() / 10000);
        account.setCustomer(customer);
        accountService.insert(account);

        CardEntity card = new CardEntity();
        card.setCardNumber((long) (Math.random() * 1000));
        card.setCvv2((long) (Math.random() * 10002));
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusYears(5);
        card.setExpireDate(dateTime);
        card.setCustomer(customer);
        cardService.insert(card);

        repository.save(customer);
    }

    public List<CustomerEntity> getAll() {

        return repository.findAll();
    }

    public List<CustomerEntity> getAllWithPageination(int pageNum,int pagSize) {

        return repository.findAll(Pageable.ofSize(pagSize).withPage(pageNum)).getContent();
    }


    public CustomerEntity updateCustomer(CustomerEntity c) throws Exception {
        try {
            CustomerEntity currentCustomer = repository.findById(c.getId()).orElse(null);
//            if (c.getId()!=null){
//                currentCustomer=
//            }
            if (c.getFirstName() != null) {
                currentCustomer.setFirstName(c.getFirstName());
            }
            if (c.getSurName() != null) {
                currentCustomer.setSurName(c.getSurName());
            }
            if (c.getNationalCode() != null) {
                currentCustomer.setNationalCode(c.getNationalCode());
            }
            if (c.getPhoneNumber() != null) {
                currentCustomer.setPhoneNumber(c.getPhoneNumber());
            }
            return repository.save(currentCustomer);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public CustomerEntity findById(Long id) throws ServiceException {


     /*   if (repository.findById(id) == null) {
            throw new ServiceException("idIsNull");

        }*/
        return repository.findById(id).get();
    }


    public void deleteById(Long id) {
//        CustomerService customerService=new CustomerService();

        repository.delete(repository.findById(id).get());
    }

/*

    //    @Async
    public CustomerEntity findByFirstName(String name) {

        return repository.findByFirstName(name);
    }
*/


/*

    public void deleteCustomerEntityByFirstName(String name) {
//        CustomerEntity d=repository.findByFirstName(name);
        repository.delete(repository.findByFirstName(name));
    }
*/
/*
    public void deleteById(String id) {
        repository.deleteById(id);

    }*/
/*
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
    }*/





/*

    public CustomerEntity updateSurName(String firstName) {
        CustomerEntity customerEntity = repository.findByFirstName(firstName);

        return repository.s
    }
*/

    public CustomerEntity update(CustomerDto customerDto) {
        CustomerEntity customerEntity = repository.findById(customerDto.getId()).orElseThrow();
        BeanUtils.copyProperties(customerDto, customerEntity);
        return customerEntity;
    }

   /* public List<CustomerEntity> sorted() {
        return repository.findByOrderByFirstNameAsc();
    }
*/
    /*public Page<CustomerEntity> findAll(CustomerEntity customer) {
        return repository.findAll(Pageable.ofSize(4));

    }*/

    public Optional<CustomerEntity> acquire(Long id) {
        return repository.findById(id);
    }



}
