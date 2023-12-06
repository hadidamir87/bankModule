package com.example.demo.service;

import com.example.demo.model.entities.CardEntity;
import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService extends BaseService<CardEntity, CardRepository> {
@Autowired
    private CustomerEntity customer;
    public void insert(CardEntity card) {
//        CardEntity cardEntity=card;
//       Long cardNumber= card.getCardNumber();
//        card.setCardNumber(card.getCardNumber());
//        card.setCvv2((long) (Math.random() * 10002));
//        Date added=new Date();
//        added.setTime(10);
      /*  LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusYears(5);
        card.setExpireDate(dateTime);*/
//        card.setCardNumber(card.getCardNumber());
//        card.getAccount().


        repository.save(card);
    }

    public CardEntity getByCardNumber(Long cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }

}
