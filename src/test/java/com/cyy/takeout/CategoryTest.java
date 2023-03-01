package com.cyy.takeout;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Category;
import com.cyy.takeout.mapper.CategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.List;

@SpringBootTest
@ServletComponentScan
@Slf4j
public class CategoryTest {
    
    @Autowired
    CategoryMapper categoryMapper;
    
    @Test
    void crudTest()
    {
        Category category=new Category();
//        category.setName("jjklhhhh");
//        category.setType(1);
//        category.setSort(3);
//        Long id=new  Long("1596145707178868739");
//        category.setId(id);
        List<Category> page = categoryMapper.page( 2, 5);
        log.info(page.toString());
    
    }
    
    
    
}
