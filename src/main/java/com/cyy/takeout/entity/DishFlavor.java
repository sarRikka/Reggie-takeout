package com.cyy.takeout.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DishFlavor implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    Long dishId;
    String name;
    String value;
    int isDelete;

    LocalDateTime updateTime;
    LocalDateTime createTime;
    Long createUser;
    Long updateUser;
}
