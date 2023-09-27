/*
package com.example.demo.controller;
*/
/*
import com.example.demo.dto.convertor.CustomerDto;
import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;*//*


import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entities.AccountEntity;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.service.CustomerService;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<CustomerEntity, CustomerDto, CustomerService> {

    //    @ResponseStatus(HttpStatus.ACCEPTED)
//    @RequestMapping("/customer")
    @PostMapping("/create")
    @Transactional

    public void insert(@RequestBody CustomerDto d) {

         service.insert(converter.convertToE(d));
    }


    @GetMapping("/get/{name}")
//    @Transactional
    public CustomerDto findByFirstName(@PathVariable String name) {
//LOGGER.info("add method called");
//LOGGER.info("add argument is"+ name);
        return converter.convertToDto(service.findByFirstName(name));
    }
*/
/*
    @DeleteMapping("/{name}")
    public void deleteCustomerByFirstName(@PathVariable String name) {
//
//        service.findByFirstName(name);
        service.deleteCustomerEntityByFirstName(name);
    }*//*


    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id) {
//
        service.deleteById(id);
    }

*/
/*
    @PutMapping("/{account}")
    public AccountEntity update(@PathVariable AccountDto accountDto) {

        return service.s
    }*//*

}
*/
