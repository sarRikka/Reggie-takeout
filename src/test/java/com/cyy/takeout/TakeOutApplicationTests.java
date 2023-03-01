package com.cyy.takeout;

import com.cyy.takeout.entity.Employee;
import com.cyy.takeout.entity.User;
import com.cyy.takeout.mapper.EmployeeMapper;
import com.cyy.takeout.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.time.LocalDateTime;

@SpringBootTest
@ServletComponentScan
@Slf4j
class TakeOutApplicationTests {

    @Autowired
    EmployeeMapper mapper;
    
    @Test
    void contextLoads() {
        
       //mapper.getAll();
        Employee employee = mapper.selectById((long) (1));
        System.out.println(employee.toString());
    }

    @Test
    void addTest()
    {
        Employee employee=new Employee();
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setId((long) 2);
        employee.setName("普通员工");
        employee.setPassword("123");
        employee.setStatus(1);
        employee.setPhone("11111");
        employee.setCreateUser((long)1);
        employee.setUpdateUser((long)1);
        employee.setUserName("阿杰");
        employee.setIdNumber("111");
        employee.setSex("男");
        
        mapper.add(employee);
    }
    
    @Test void deleteTest()
    {
        mapper.deleteById((long)2);
    }
    
    @Test void updateTest()
    {
        Employee employee=new Employee();
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setId((long) 2);
        employee.setName("不怎么普通的员工");
        employee.setPassword("123");
        employee.setStatus(1);
        employee.setPhone("11111");
        employee.setCreateUser((long)1);
        employee.setUpdateUser((long)1);
        employee.setUserName("阿杰");
        employee.setIdNumber("111");
        employee.setSex("男");

        mapper.update(employee);
    }
    
    @Test
    public void selectByNameTest()
    {
        Employee employee = mapper.selectByName("阿杰");
        log.info(employee.toString());
    }
    
    @Test
    public void pageTest()
    {
        System.out.println(mapper.page("c",0,3).toString());
    }
    @Autowired
    UserMapper userMapper;
    
    @Test
    public void tt()
    {
        User user=new User();
        user.setAvatar("312");
        user.setName("312");
        user.setStatus(1);
        user.setPhone("131231");
        user.setIdNumber("132");
        user.setSex("男");
        
        userMapper.insert(user);
    }
    
}
