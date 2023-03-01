package com.cyy.takeout.controller;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.dto.SetmealDto;
import com.cyy.takeout.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    
    @Autowired
    SetmealService service;
    
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto)
    {
        service.save(setmealDto);
        return R.success("存储成功");
    }
    
    @DeleteMapping
    public R<String> deleteBaches(@RequestParam List<Long> ids)
    {
        service.deleteBaches(ids);
        return R.success("删除成功");
    }
    
    @GetMapping("/list")
    public R<List<SetmealDto>> list(Long categoryId,int status)
    {
        return R.success(service.list(categoryId,status));
    }
    
    @GetMapping("/page")
    public R<Page<SetmealDto>> page(String name,int page,int pageSize)
    {
        return R.success(service.page(name,page,pageSize));
    }
    
    
    
}
