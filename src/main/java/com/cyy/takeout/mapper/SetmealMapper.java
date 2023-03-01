package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealMapper {
    
    public boolean insert(Setmeal setmeal);
    
    public boolean delete(Long id);
    
    public List<Setmeal> list(Long categoryId, int status);
    
    public List<Setmeal> page(String name,int diff,int pageSize);
    
    public int count(String name);
    
}
