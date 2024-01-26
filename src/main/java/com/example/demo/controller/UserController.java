package com.example.demo.controller;

import com.example.demo.exceptionHandller.exceptions.ServiceException;
import com.example.demo.model.dto.CustomerDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.role.UserEntity;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restForUser")
public class UserController extends BaseController<UserEntity, UserDto, UserService>{


    @PostMapping("/createUser")
    @Transactional
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void insert(@Validated @RequestBody UserDto d) throws ServiceException {

        service.add(converter.convertToE(d));
    }

    @PutMapping("/updateUser")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserDto update(@RequestBody UserDto userDto) throws Exception {

        return converter.convertToDto(service.update(converter.convertToE(userDto)));
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
    public UserDto findById(@PathVariable Long id) throws ServiceException {
//LOGGER.info("add method called");
//LOGGER.info("add argument is"+ name);
      /*  if (repository.findById(id) == null) {
            throw new ServiceException("IdNotFound");
        }*/
        return converter.convertToDto(service.findById(id));
    }


    @GetMapping("/getAllUsers")
    public List<UserDto> getAllEntities() {

        return converter.collectionConvertorToDto(service.getAll());
    }

    @GetMapping("/getAllWithPagination")
    public List<UserDto> getAllUsersWithPagination(@RequestParam("pageIndex") int pageIndex) {

        return converter.collectionConvertorToDto(service.getAllWithPagination(pageIndex));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) throws ServiceException {

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
