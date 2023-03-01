package com.cyy.takeout.controller;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Category;
import com.cyy.takeout.service.CategoryService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
    
    @PostMapping
    public R<String> save(@RequestBody Category category)
    {
        categoryService.save(category);
        return R.success("保存成功");
    }
    
    @PutMapping
    public R<String> update(@RequestBody Category category)
    {
        categoryService.update(category);
        return R.success("更新成功");
    }
    
    @DeleteMapping
    public R<String> delete(Long ids)
    {
        categoryService.delete(ids);
        return R.success("删除成功");
    }
    
    @GetMapping("/list")
    public R<List<Category>> list(Category category)
    {
        return R.success(categoryService.list(category));
    }
    
    @GetMapping("/page")
    public R<Page<Category>> page(int page, int pageSize)
    {
        return R.success(categoryService.page(page,pageSize));
    }
    
}
