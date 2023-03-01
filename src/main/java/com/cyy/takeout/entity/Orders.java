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
public class Orders implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    String number;
    int status;
    Long userId;
    Long addressBookId;
    LocalDateTime orderTime;
    LocalDateTime checkoutTime;
    int payMethod;
    BigDecimal amount;
    String remark;
    String phone;
    String address;
    String userName;
    String consignee;
    
}
