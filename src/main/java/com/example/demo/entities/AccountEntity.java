package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

//import javax.persistence.*;
import java.util.Date;

//@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity extends EssentialEntity {
    @Column(unique = true, nullable = false)
    private Long accountNumber;
//    private Long amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id" /*,referencedColumnName = "id"*/)
    private CardEntity card;

   /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_number", referencedColumnName = "id")
    private AccountEntity account;
*/



   /*
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private CardEntity card;
*/


/*

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
*/


}
