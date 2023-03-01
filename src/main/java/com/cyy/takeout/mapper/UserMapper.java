package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    
    public boolean insert(User user);
    
    public User selectByPhone(String phone);
    
    public User getById(Long id);
    
}
