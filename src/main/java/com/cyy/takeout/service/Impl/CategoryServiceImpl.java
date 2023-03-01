package com.cyy.takeout.service.Impl;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Category;
import com.cyy.takeout.mapper.CategoryMapper;
import com.cyy.takeout.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper mapper;
    
    @Override
    public boolean save(Category category) {
        return mapper.save(category);
    }

    @Override
    public boolean update(Category category) {
        return mapper.update(category);
    }

    @Override
    public boolean delete(Long id) {
        return mapper.delete(id);
    }

    @Override
    public List<Category> list(Category category) {
        return mapper.list(category);
    }

    @Override
    public Page<Category> page(int page, int pageSize) {
        List<Category> page1 = mapper.page((page - 1) * pageSize, pageSize);
        Page<Category> page2=new Page<>();
        page2.setSize(pageSize);
        page2.setCurrent(page);
        page2.setTotal(mapper.count());
        page2.setRecords(page1);
        return page2;
    }
}
