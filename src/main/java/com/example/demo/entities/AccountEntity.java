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
public class AccountEntity extends EssentialEntity {
    @Column(unique = true, nullable = false)
    private Long accountNumber;
    @Column(unique = true, nullable = false)
    private Integer cvv2;
//    private Date expireDate;

 /*   @OneToOne
    private CardEntity cardNumber;
    */

   /* @ManyToOne
    @JoinColumn(name = "customer_id")
    @Column(unique = true,nullable = false)
    private CustomerEntity customer;
    */


}
