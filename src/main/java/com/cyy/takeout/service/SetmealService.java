package com.cyy.takeout.service;

import com.cyy.takeout.common.Page;
import com.cyy.takeout.common.R;
import com.cyy.takeout.dto.SetmealDto;
import com.cyy.takeout.mapper.SetmealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface SetmealService {
    
    
    public boolean save(SetmealDto setmealDto);

    
    public boolean deleteBaches(List<Long> ids);

    
    public List<SetmealDto> list(Long categoryId,int status);
    
    
    public Page<SetmealDto> page(String name, int page, int pageSize);
    
}
