package com.cyy.takeout;

import com.cyy.takeout.entity.ShoppingCart;
import com.cyy.takeout.mapper.ShoppingCartMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@Slf4j
public class ShoppingCartTest {
    
    @Autowired
    ShoppingCartMapper mapper;
    
    @Test
    public void test()
    {
        ShoppingCart cart=new ShoppingCart();
        BigDecimal bigDecimal=new BigDecimal("123");
        cart.setAmount(bigDecimal);
        cart.setUserId((long)123);
        cart.setDishId((long)12);
        cart.setNumber(222);
        cart.setId(new Long("1600706843136094211"));
        mapper.clean(new Long("1600706780028596225"));
        ShoppingCart one = mapper.getOne(cart);log.info(one.toString());
        
        //List<ShoppingCart> list = mapper.list(new Long("1600706780028596225"));
        //log.info(list.toString());
        
    }
    
}
