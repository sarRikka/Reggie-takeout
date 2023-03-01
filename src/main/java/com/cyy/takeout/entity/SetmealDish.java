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
public class SetmealDish implements Serializable {
    
    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    Long setmealId;
    Long dishId;
    String name;
    BigDecimal price;
    int copies;
    int sort;
    int isDeleted;
    LocalDateTime updateTime;
    LocalDateTime createTime;
    Long createUser;
    Long updateUser;
    
}
