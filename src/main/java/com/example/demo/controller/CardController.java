package com.example.demo.controller;

import com.example.demo.model.dto.CardDto;
import com.example.demo.model.entities.CardEntity;
import com.example.demo.service.CardService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/card")

public class CardController extends BaseController<CardEntity, CardDto, CardService> {
    @PostMapping("/createCard")
//    @ResponseStatus(HttpStatus.CREATED)
//    @Transactional
    public void add(@RequestBody CardDto cardDto) {
//        Integer accountNumber = converter.convertToE(cardDto).getAccount().getAccountNumber();

//        cardDto.setAccount(service.getByCardNumber(cardDto.getCardNumber()));
//        cardDto.getAccount().setAccountNumber(converter.convertToE(cardDto).getCardNumber());

        service.insert(converter.convertToE(cardDto));

    }

    @GetMapping("/get/{card_number}")
//    @Transactional
    public CardDto findByCardNumber(/*@PathVariable*/ Long cardNumber) {
        return converter.convertToDto(service.getByCardNumber(cardNumber));
    }

}
