package com.cyy.takeout.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    int status;
    String name;
    String phone;
    String sex;
    String idNumber;
    String avatar;
    
}
