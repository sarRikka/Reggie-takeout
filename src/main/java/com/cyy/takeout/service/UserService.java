package com.cyy.takeout.service;

import com.cyy.takeout.entity.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    
    User save(String phone, HttpServletRequest request);
    
    
}
