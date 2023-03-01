package com.cyy.takeout.service;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService {
    
    public Employee save(Employee employee);
    
    public boolean update(Employee employee);
    
    public R<Employee> login(Employee employee, HttpServletRequest request);
    
    public boolean logout(HttpServletRequest request);
    
    public R<Page<Employee>> page(String name,int page,int pageSize);
    
}
