package com.cyy.takeout.mapper;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.dto.DishDto;
import com.cyy.takeout.entity.Dish;
import com.cyy.takeout.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface DIshMapper {


    public boolean save(DishDto dto);


    public boolean update(DishDto dto);


    public List<Dish> list(long categoryId);//categoryId


    public List<Dish> page(String name, int diff, int pageSize);


    public Dish getById(Long id);
    
    public int count();
    
    public Dish getByName(String name);
    
}
