package com.example.demo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Data
public class AbstractDto {

    private Long id;
    private Integer version;
    private Date insertTimestamp;
    private Date lastUpdateTimestamp;

}

