package com.cyy.takeout.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    
    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    String idNumber;
    String name;//职位
    @JsonAlias("username")
    String userName;//真实姓名
    String password;
    String phone;
    String sex;
    int status;
    LocalDateTime updateTime;
    LocalDateTime createTime;
    Long createUser;
    Long updateUser;
    
    
    
    
}
