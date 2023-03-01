package com.cyy.takeout.controller;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.dto.DishDto;
import com.cyy.takeout.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {
    
    @Autowired
    DishService dishService;
    
    @PostMapping
    public R<String> save(@RequestBody DishDto dto)
    {
        dishService.save(dto);
        return R.success("dish保存成功");
    }
    
    @PutMapping
    public R<String> update(@RequestBody DishDto dto)
    {
        dishService.update(dto);
        return R.success("dish更新成功");
    }    
    
    @GetMapping("/list") 
    public R<List<DishDto>> list(DishDto dto)//categoryId
    {
        return R.success(dishService.list(dto));
    }
    
    @GetMapping("/page")
    public R<Page<DishDto>> page(String name,int page,int pageSize)
    {
        return R.success(dishService.page(name,page,pageSize));
    }    
    
    @GetMapping("/{id}")
    public R<DishDto> getById(@PathVariable Long id)
    {
        return R.success(dishService.getById(id));
    }

}
