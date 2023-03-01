package com.cyy.takeout.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    String name;
    Long categoryId;
    BigDecimal price;
    String code;
    String image;
    String description;
    int status;
    int sort;
    int isDeleted;
    LocalDateTime updateTime;
    LocalDateTime createTime;
    Long createUser;
    Long updateUser;
    
}
