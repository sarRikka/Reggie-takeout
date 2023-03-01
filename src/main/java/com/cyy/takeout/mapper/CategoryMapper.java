package com.cyy.takeout.mapper;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    
    public boolean save(Category category);

    
    public boolean update(Category category);

    
    public boolean delete(Long id);

    
    public List<Category> list(Category category);

    
    public List<Category> page(int diff,int num);
    
    public int count();
}
