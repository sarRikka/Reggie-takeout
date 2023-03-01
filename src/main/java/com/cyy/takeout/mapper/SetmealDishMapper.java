package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    
    public boolean insert(SetmealDish setmealDish);
    
    public boolean delete(Long setmealId);
    
    public List<SetmealDish> getBySetmealId(Long setmealId);
    
    
    
}
