package com.example.demo.aspects;


import com.example.demo.repositories.LogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;


import com.example.demo.repositories.LogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
@Slf4j
public class ControllerAspect {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private LogRepository logRepository;

    @Around("within(com.example.demo.controller.BaseController+ )")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LogModel logModel = new LogModel();
        logModel.setMethodName(joinPoint.getSignature().getName());
        logModel.setRequest(joinPoint.getArgs());
        logRepository.save(logModel);

        Object value;
        try {
            value = joinPoint.proceed();
            if (value != null) {
                logModel.setResponse(value);
            }
//            logRepository.save(logModel);
//            log.info("Success req " + objectMapper.writeValueAsString(logModel));
        } catch (Throwable e) {

            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());
            logRepository.save(logModel);
            log.error("Failure req " + objectMapper.writeValueAsString(logModel));
            throw e;
        }
        return value;
    }

   /* @PostConstruct
    public void init() {
        LogModel logModel = new LogModel();
        logModel.setName("hadi");
        logModel.setFamily("damiroghli");
        logRepository.save(logModel);
//        System.out.println(logModel);
    }*/

   /* @Around("within(com.example.demo.controller.BaseController+ )")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LogModel logModel = new LogModel();
        logModel.setMethodName(joinPoint.getSignature().getName());
        logModel.setRequest(joinPoint.getArgs());
        logRepository.save(logModel);

        Object value;
        try {
            value = joinPoint.proceed();
            if (value != null) {
                logModel.setResponse(value);
            }
//            logRepository.save(logModel);
//            log.info("Success req " + objectMapper.writeValueAsString(logModel));
        } catch (Throwable e) {

            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());
            logRepository.save(logModel);
            log.error("Failure req " + objectMapper.writeValueAsString(logModel));
            throw e;
        }
        return value;
    }*/

    // TODO: 10/25/2023 record log in mongoDB.
/*
    @Around("within(com.example.demo.controller.BaseController +)")
    public Object logForController(ProceedingJoinPoint joinPoint) throws Throwable {
        LogModel logModel = new LogModel();
        logModel.setMethodName(joinPoint.getSignature().getName());
        logModel.setRequest(joinPoint.getArgs());
        Object value;
        try {
            value = joinPoint.proceed();
//            System.out.println(joinPoint.proceed());
            if (value != null) {
                logModel.setResponse(value);
            }
            logRepository.save(logModel);
            log.info("Success req " + objectMapper.writeValueAsString(logModel));
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());
            logRepository.save(logModel);
            log.error("Failure req " + objectMapper.writeValueAsString(logModel));
            throw e;

        }
        return value;
    }*/

}

