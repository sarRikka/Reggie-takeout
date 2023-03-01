package com.cyy.takeout.service;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryService {



    public boolean save(@RequestBody Category category);


    public boolean update(Category category);


    public boolean delete(Long id);


    public List<Category> list(Category category);


    public Page<Category> page(int diff, int num);
    
}
