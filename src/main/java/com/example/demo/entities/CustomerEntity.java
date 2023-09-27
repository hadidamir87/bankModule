/*
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.util.List;

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
    // @Column(name = "cus")
    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AccountEntity> accounts;
}
*/
