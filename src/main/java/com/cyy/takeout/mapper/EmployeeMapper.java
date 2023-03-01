package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    
    public boolean add(Employee employee);
    
    public Employee selectById(Long id);
    
    public Employee selectByName(String userName);
    
    public boolean deleteById(long id);
    
    public boolean update(Employee employee);
    
    //@Select("select count(*) from employee")
    public int getAll();
    
    public List<Employee> page(String name,int begin,int num);
    
    public int getCount(String name);
    
    
    
}
