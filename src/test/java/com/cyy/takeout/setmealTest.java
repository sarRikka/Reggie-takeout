package com.cyy.takeout;

import com.cyy.takeout.entity.Setmeal;
import com.cyy.takeout.entity.SetmealDish;
import com.cyy.takeout.mapper.SetmealDishMapper;
import com.cyy.takeout.mapper.SetmealMapper;
import com.mysql.cj.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Slf4j
public class setmealTest {

    @Autowired
    SetmealMapper setmealMapper;
    @Autowired
    SetmealDishMapper setmealDishMapper;
    
    @Test
    public void setmeal()
    {
        Setmeal setmeal=new Setmeal();
        setmeal.setCode("123");
        setmeal.setDescription("jkl");
        setmeal.setName("setmeal");
        setmeal.setStatus(0);
        setmeal.setCategoryId((long) 123);
        setmeal.setImage("asd");
        setmeal.setIsDeleted(0);
        BigDecimal bigDecimal=new BigDecimal("1.3");
        setmeal.setPrice(bigDecimal);
        setmeal.setCreateUser((long)1);
        setmeal.setUpdateUser((long)1);
        setmeal.setCreateTime(LocalDateTime.now());
        setmeal.setUpdateTime(LocalDateTime.now());
        List<Setmeal> list = setmealMapper.page( null,1,2);    
        log.info(list.toString());
    }    
    
    @Test
    public void setmealDishTest()
    {
        SetmealDish dish=new SetmealDish();
        dish.setName("123");
        BigDecimal bigDecimal=new BigDecimal("1.3");
        dish.setPrice(bigDecimal);
        dish.setSort(1);
        dish.setCopies(1);
        dish.setSetmealId((long)132);
        dish.setDishId((long)32);

        List<SetmealDish> id = setmealDishMapper.getBySetmealId((new Long("1609492843418640385")));
        log.info(id.toString());
    }
    
}
