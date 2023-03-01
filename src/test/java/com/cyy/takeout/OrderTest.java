package com.cyy.takeout;

import com.cyy.takeout.entity.OrderDetail;
import com.cyy.takeout.entity.Orders;
import com.cyy.takeout.mapper.OrderDetailMapper;
import com.cyy.takeout.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
public class OrderTest {
    
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    
    @Test
    public void test()
    {
//        Orders orders=new Orders();
//        orders.setAddress("ad");
//        orders.setAmount(new BigDecimal("123"));
//        orders.setAddressBookId((long)123);
//        orders.setNumber("da");
//        orders.setPayMethod(1);
//        orders.setUserId((long)132);
//        orders.setOrderTime(LocalDateTime.now());
//        orderMapper.insert(orders);

        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setOrderId((long)123);
        orderDetail.setAmount(new BigDecimal("321"));
        orderDetail.setNumber(2);
        orderDetailMapper.insert(orderDetail);
        
    }
    
}
