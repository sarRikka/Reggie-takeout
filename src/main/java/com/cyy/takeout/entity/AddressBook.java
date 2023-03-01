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
public class AddressBook implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    Long id;
    Long userId;
    String consignee;
    int sex;
    int isDefault;
    int isDeleted;
    String phone;
    String provinceCode;
    String provinceName;
    String cityCode;
    String cityName;
    String districtCode;
    String districtName;
    String detail;
    String label;
    LocalDateTime updateTime;
    LocalDateTime createTime;
    Long createUser;
    Long updateUser;
    
}
