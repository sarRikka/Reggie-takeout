package com.cyy.takeout.controller;

import com.aliyun.tea.utils.StringUtils;
import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.User;
import com.cyy.takeout.service.UserService;
import com.cyy.takeout.utils.MessageSendUtil;
import com.cyy.takeout.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user)
    {

        try {
            if(!StringUtils.isEmpty(user.getPhone()))
            {
                
                String code = ValidateCodeUtils.generateValidateCode(4).toString();
                MessageSendUtil.sendMsg(user.getPhone(),code);
                return R.success("发送短信成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error("发送短信失败");
        
    }
    
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map,HttpServletRequest request)
    {
        String phone=map.get("phone").toString();
        //1.根据phone找user，user为空存储库，否则直接返回记得放入userId
        return R.success(userService.save(phone,request));
    }
    
}
