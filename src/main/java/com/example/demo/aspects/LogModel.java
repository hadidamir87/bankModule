package com.example.demo.aspects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.lang.annotation.Documented;

@Data
@Document(collection = "bank'sLog")
public class LogModel {
//    @MongoId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String methodName;
    private Object request;
    private Object response;
    private String errorTrace;


}
