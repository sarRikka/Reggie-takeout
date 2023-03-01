package com.cyy.takeout.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    String name;
    String image;
    Long orderId;
    Long dishId;
    Long setmealId;
    String dishFlavor;
    int number;
    BigDecimal amount;
    
}
