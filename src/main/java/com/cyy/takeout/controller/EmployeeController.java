package com.cyy.takeout.controller;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Employee;
import com.cyy.takeout.mapper.EmployeeMapper;
import com.cyy.takeout.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeMapper mapper;
    
    @Autowired
    EmployeeService service;
    
    @PostMapping
    public R<Employee> save(@RequestBody Employee employee)
    {
        service.save(employee);
        return R.success(employee);
    }
    
    @PutMapping
    public R<String> update(@RequestBody Employee employee)
    {
        service.update(employee);
        return R.success("更新成功");
    }
    
    @PostMapping("/login")
    public R<Employee> login(@RequestBody Employee employee, HttpServletRequest request)
    {
        return service.login(employee,request);
    }
    
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request)
    {
        service.logout(request);
        return R.success("退出成功");
    }
    
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id)
    {
        Employee employee = mapper.selectById(id);
        return R.success(employee);
    }
    
    @GetMapping("/page")
    public R<Page<Employee>> page(String name,Integer page,Integer pageSize)
    {
        return service.page(name,page,pageSize);
    }    
    
    
    
    
}
