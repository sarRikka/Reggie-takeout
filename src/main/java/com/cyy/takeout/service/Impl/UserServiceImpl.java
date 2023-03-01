package com.cyy.takeout.service.Impl;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.User;
import com.cyy.takeout.mapper.UserMapper;
import com.cyy.takeout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserMapper mapper;
    
    @Override
    public User save(String phone,HttpServletRequest request) {
        
        //验证code 是否正确
        
        User user1=mapper.selectByPhone(phone);
        if(user1 == null)
        {
            user1=new User();
            user1.setPhone(phone);
            mapper.insert(user1);
        }
        
        request.getSession().setAttribute("user",user1.getId());
        return user1;
    }
}
