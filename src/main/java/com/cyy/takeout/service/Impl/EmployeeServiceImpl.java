package com.cyy.takeout.service.Impl;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Employee;
import com.cyy.takeout.mapper.EmployeeMapper;
import com.cyy.takeout.service.EmployeeService;
import com.cyy.takeout.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeMapper mapper;
    
    @Override
    public Employee save(Employee employee) {
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        mapper.add(employee);
        log.info(employee.toString());
        return mapper.selectById(employee.getId());
    }

    @Override
    public boolean update(Employee employee) {
        return mapper.update(employee);
    }

    @Override
    public R<Employee> login(Employee employee, HttpServletRequest request) {
        Employee employee1 = mapper.selectByName(employee.getUserName());
        if(employee1==null)
        {
            return R.error("没有该用户");
        }
        String pass= DigestUtils.md5DigestAsHex(employee.getPassword().getBytes());
        if(!pass.equals(employee1.getPassword()))
        {
            return R.error("密码不正确");
        }
        if(employee1.getStatus()==0)
        {
            return R.error("状态不可用");
        }
        request.getSession().setAttribute("employee",employee1.getId());
        return R.success(employee1);
    }

    @Override
    public boolean logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return true;
    }

    @Override
    public R<Page<Employee>> page(String name, int page, int pageSize) {
        int diff=(page-1)*pageSize;
        Page<Employee> page1=new Page<>();
        page1.setCurrent(page);
        page1.setRecords(mapper.page(name,diff,pageSize));
        page1.setTotal(10);
        page1.setTotal((mapper.getCount(name)-1)/pageSize+1);
        return R.success(page1);
    }
}
