package com.example.demo.controller;

import com.example.demo.exceptionHandller.exceptions.ServiceException;
import com.example.demo.service.CustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.dto.CustomerDto;
import com.example.demo.model.entities.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")

public class CustomerController extends BaseController<CustomerEntity, CustomerDto, CustomerService> {

    @PostMapping("/createCustomer")
    @Transactional
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void insert(@Validated @RequestBody CustomerDto d) throws ServiceException {
//        LOGGER.debug("insert method is called.");
//        LOGGER.info("insert method in customerController's class called.",d);
        service.insert(converter.convertToE(d));
    }
    // TODO: 10/25/2023 implement validation.


    @PutMapping("/updateCustomer")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
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
    public CustomerDto findById(@PathVariable Long id) throws ServiceException {
//LOGGER.info("add method called");
//LOGGER.info("add argument is"+ name);
      /*  if (repository.findById(id) == null) {
            throw new ServiceException("IdNotFound");
        }*/
        return converter.convertToDto(service.findById(id));
    }


    @GetMapping("/getAll")
    public List<CustomerDto> getAllEntities() {
        /*List<CustomerEntity> customerEntityList=service.findAll();
        List<String> myList = new ArrayList<String>();
        myList.forEach(str -> System.out.println(str));
        customerEntityList.forEach(customer -> customer.);*/

        return converter.collectionConvertorToDto(service.getAll());
    }

/*
    @GetMapping()
    public List<CustomerEntity> getAll(@RequestParam ){
        return service.sorted();
    }
*/

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
