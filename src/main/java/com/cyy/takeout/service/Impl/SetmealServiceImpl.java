package com.cyy.takeout.service.Impl;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.dto.SetmealDto;
import com.cyy.takeout.entity.Category;
import com.cyy.takeout.entity.Setmeal;
import com.cyy.takeout.entity.SetmealDish;
import com.cyy.takeout.mapper.CategoryMapper;
import com.cyy.takeout.mapper.SetmealDishMapper;
import com.cyy.takeout.mapper.SetmealMapper;
import com.cyy.takeout.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    SetmealMapper setmealMapper;
    @Autowired
    SetmealDishMapper setmealDishMapper;
    @Autowired
    CategoryMapper categoryMapper;
    
    @Override
    public boolean save(SetmealDto setmealDto) {
        setmealMapper.insert(setmealDto);
        for (SetmealDish setmealDish : setmealDto.getSetmealDishes()) {
            setmealDish.setSetmealId(setmealDto.getId());
            setmealDishMapper.insert(setmealDish);
        }
        return true;
    }

    @Override
    public boolean deleteBaches(List<Long> ids) {
        for (Long id : ids) {
            
            setmealMapper.delete(id);
            setmealDishMapper.delete(id);
            
        }
        return true;
    }

    @Override
    public List<SetmealDto> list(Long categoryId, int status) {
        List<Setmeal> list = setmealMapper.list(categoryId, status);
        List<SetmealDto> collect = list.stream().map((setmeal) ->
        {
            SetmealDto dto = new SetmealDto();
            BeanUtils.copyProperties(setmeal, dto);
            Category category = new Category();
            category.setId(categoryId);
            Category category1 = categoryMapper.list(category).get(0);
            dto.setCategoryName(category1.getName());
            dto.setSetmealDishes(setmealDishMapper.getBySetmealId(setmeal.getId()));
            return dto;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Page<SetmealDto> page(String name, int page, int pageSize) {
        List<Setmeal> list = setmealMapper.page(name,(page-1)*pageSize,pageSize);
        Page<SetmealDto> page1=new Page<>();
        page1.setSize(pageSize);
        page1.setCurrent(page);
        page1.setTotal(setmealMapper.count(name));
        List<SetmealDto> collect = list.stream().map((setmeal) ->
        {
            SetmealDto dto = new SetmealDto();
            BeanUtils.copyProperties(setmeal, dto);
            Category category = new Category();
            category.setId(setmeal.getCategoryId());
            Category category1 = categoryMapper.list(category).get(0);
            dto.setCategoryName(category1.getName());
            dto.setSetmealDishes(setmealDishMapper.getBySetmealId(setmeal.getId()));
            return dto;
        }).collect(Collectors.toList());
        page1.setRecords(collect);
        return page1;
    }
}
