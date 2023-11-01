package com.example.demo.repositories;

import com.example.demo.model.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
    CardEntity findByCardNumber(Long cardNumber);
}
