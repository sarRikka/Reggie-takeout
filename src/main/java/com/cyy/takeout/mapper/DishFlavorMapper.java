package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    
    public boolean insert(DishFlavor dishFlavor);
    
    public boolean deleteByDishId(Long dishId);
    
    public List<DishFlavor> selectByDishId(Long id);
    
}
