package com.example.demo.controller;

import com.example.demo.exceptionHandller.exceptions.DuplicateEntry;
import com.example.demo.exceptionHandller.exceptions.ServiceException;
import com.example.demo.exceptionHandller.exceptions.handledExceptions.CheckNullityOfCreateCustomer;
import com.example.demo.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entities.CustomerEntity;

import java.sql.SQLException;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<CustomerEntity, CustomerDto, CustomerService> {

    @PostMapping("/createCustomer")
    @Transactional

    public void insert(@RequestBody CustomerDto d) throws Exception {
        service.insert(converter.convertToE(d));
    }

    @PutMapping("/updateCustomer")
    public CustomerDto update(@RequestBody CustomerDto customerDto) throws Exception {
        return converter.convertToDto(service.updateCustomer(converter.convertToE(customerDto)));
    }

    /*

        @PutMapping("/updateCustomer")
        public CustomerDto update(@PathVariable Long id) throws Exception {
            service.updateById(service.findById(id));
            return converter.convertToDto(service.findById(id));
    //        return convertor.convertSrv(service.updateById(convertor.convertDto(dto)));
    //        return converter.convertToDto(service.updateById(converter.convertToE(customerDto)));
        }

    */
    @GetMapping("/get/{id}")
//    @Transactional
    public CustomerDto findById(@PathVariable Long id) throws CheckNullityOfCreateCustomer {
//LOGGER.info("add method called");
//LOGGER.info("add argument is"+ name);
        return converter.convertToDto(service.findById(id));
    }


    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id) throws ServiceException {

        service.deleteById(id);
    }

   /*
    @DeleteMapping("/{name}")
    public void deleteCustomerByFirstName(@PathVariable String name) {
//
//        service.findByFirstName(name);
        service.deleteCustomerEntityByFirstName(name);
    }
*/

}
