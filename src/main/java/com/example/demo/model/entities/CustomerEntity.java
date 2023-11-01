package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

//import javax.persistence.*;


@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Data
@Component
public class CustomerEntity extends EssentialEntity {
    @Column
    private String firstName;
    @Column
    private String surName;
    @Column(unique = true, nullable = false)
    private Long nationalCode;
    @Column(unique = true, nullable = false)
    private Long phoneNumber;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private AccountEntity account;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CardEntity> cards;

}