package com.cyy.takeout;

import com.cyy.takeout.entity.Dish;
import com.cyy.takeout.entity.DishFlavor;
import com.cyy.takeout.mapper.DIshMapper;
import com.cyy.takeout.mapper.DishFlavorMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@Slf4j
public class DishTest {
    
    @Autowired
    DishFlavorMapper dishFlavorMapper;
    
    @Autowired
    DIshMapper dIshMapper;
    
    @Test
    public void flavorTest()
    {
        DishFlavor dishFlavor=new DishFlavor();
        dishFlavor.setName("酸甜苦啦");
        dishFlavor.setValue("very酸");
        dishFlavor.setDishId((long)123);
        Long num=new Long("1597803491968466949");
        
    }
    
    @Test
    public void dishTest()
    {
        Dish dish=new Dish();
        dish.setCode("1");
        dish.setCategoryId(new Long("1397844263642378242"));
        dish.setName("jjjjjjjjjjjj");
        dish.setDescription("dsa");
        dish.setImage("dsa");
        BigDecimal bigDecimal=new BigDecimal(0.3);
        dish.setPrice(bigDecimal);
        dish.setSort(3);
        dish.setStatus(1);
        dish.setId(new Long("1597803491968466947"));
        dIshMapper.getById(new Long("1597803491968466946"));
    }
    
}
