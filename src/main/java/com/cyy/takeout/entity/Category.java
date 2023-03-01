package com.cyy.takeout.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    
    String name;
    
    int type;
    
    int sort;

    LocalDateTime updateTime;
    LocalDateTime createTime;
    Long createUser;
    Long updateUser;
}
