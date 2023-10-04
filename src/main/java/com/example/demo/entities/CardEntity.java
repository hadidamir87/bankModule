
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;


@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CardEntity extends EssentialEntity {
    //    private Long balance;
    @Column(unique = true, nullable = false)
    private Long cardNumber;

    @Column(unique = true, nullable = false)
    private LocalDateTime expireDate;

    @Column(unique = true, nullable = false)
    private Long cvv2;
/*

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
*/

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;


/*
    @ManyToOne
    private CustomerEntity customer;*/
    /*

    @OneToOne(mappedBy = "card",cascade = CascadeType.ALL)
    private AccountEntity account;
*/
   /*
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private CardEntity card;
*/


    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_number", referencedColumnName = "id")
    private AccountEntity account;
*/

}


