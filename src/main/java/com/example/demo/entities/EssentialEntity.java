package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@Data
//@Getter
//@Setter
@EntityListeners(AuditingEntityListener.class)

public abstract class EssentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Version
    private Integer version;
    @CreatedDate
    private Date insertTimestamp;
    @LastModifiedDate
    private Date lastUpdateTimestamp;
}
