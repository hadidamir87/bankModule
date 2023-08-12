package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

//import javax.persistence.*;


@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Data
public class CustomerEntity extends EssentialEntity {
    @Column
    private String firstName;
    @Column
    private String surName;
//    @Column(unique = true,nullable = false)
//    private Integer nationalCode;

    /*
    @OneToMany
    private List<AccountEntity> accounts;
*/
}
