package com.cyy.takeout.service;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.dto.DishDto;
import com.cyy.takeout.entity.Dish;
import com.cyy.takeout.entity.DishFlavor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public interface DishService {

    public boolean save(DishDto dto);


    public boolean update(DishDto dto);


    public List<DishDto> list(DishDto dto);//categoryId


    public Page<DishDto> page(String name, int page, int pageSize);


    public DishDto getById(Long id);
    
}
