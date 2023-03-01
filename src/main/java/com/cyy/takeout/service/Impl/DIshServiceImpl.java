package com.cyy.takeout.service.Impl;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.dto.DishDto;
import com.cyy.takeout.entity.Category;
import com.cyy.takeout.entity.Dish;
import com.cyy.takeout.entity.DishFlavor;
import com.cyy.takeout.mapper.CategoryMapper;
import com.cyy.takeout.mapper.DIshMapper;
import com.cyy.takeout.mapper.DishFlavorMapper;
import com.cyy.takeout.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DIshServiceImpl implements DishService {

    @Autowired
    DIshMapper dIshMapper;
    @Autowired
    DishFlavorMapper dishFlavorMapper;
    @Autowired
    CategoryMapper categoryMapper;
    
    @Transactional
    public boolean save(DishDto dto)
    {
        dIshMapper.save(dto);

        Dish byName = dIshMapper.getByName(dto.getName());
        
        for (DishFlavor flavor : dto.getFlavors()) {
            
            flavor.setDishId(byName.getId());
            dishFlavorMapper.insert(flavor);
        }
        return true;
    }

    
    public boolean update(DishDto dto)
    {
        dIshMapper.update(dto);
        dishFlavorMapper.deleteByDishId(dto.getId());
        for (DishFlavor flavor : dto.getFlavors()) {
            flavor.setDishId(dto.getId());
            dishFlavorMapper.insert(flavor);
        }
        return true;
    }

    
    public List<DishDto> list(DishDto dto)//categoryId
    {
        List<Dish> list = dIshMapper.list(dto.getCategoryId());
        List<DishDto> list1= list.stream().map((dish)->
                {
                    DishDto dishDto=new DishDto();
                    BeanUtils.copyProperties(dish,dishDto);
                    dishDto.setFlavors(dishFlavorMapper.selectByDishId(dish.getId()));
                    //categoryName
                    return dishDto;                    
                }
                
        ).collect(Collectors.toList());
        return list1;
    }

    
    public Page<DishDto> page(String name, int page, int pageSize)
    {
        List<Dish> list = dIshMapper.page(name, (page - 1) * pageSize, pageSize);   
        Page<DishDto> dtoPage= new Page<>();
        dtoPage.setCurrent(page);
        dtoPage.setSize(pageSize);
        dtoPage.setTotal((long) dIshMapper.count());
        List<DishDto> listDto= list.stream().map(
                (dish)->
                {
                    DishDto dto=new DishDto();
                    BeanUtils.copyProperties(dish,dto);
                    Category category=new Category();
                    category.setId(dish.getCategoryId());
                    List<Category> categoryList = categoryMapper.list(category);
                    dto.setCategoryName(categoryList.get(0).getName());
                    dto.setFlavors(dishFlavorMapper.selectByDishId(dish.getId()));
                    return dto;
                }
        ).collect(Collectors.toList());
        dtoPage.setRecords(listDto);
        return dtoPage;
    }

    
    public DishDto getById(Long id)
    {
        Dish dish =dIshMapper.getById(id);
        DishDto dto=new DishDto();
        BeanUtils.copyProperties(dish,dto);
        dto.setFlavors(dishFlavorMapper.selectByDishId(id));
        return dto; 
    }
    
}
