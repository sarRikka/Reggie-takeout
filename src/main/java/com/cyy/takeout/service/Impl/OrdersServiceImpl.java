package com.cyy.takeout.service.Impl;

import com.cyy.takeout.entity.*;
import com.cyy.takeout.mapper.*;
import com.cyy.takeout.service.AddressBookService;
import com.cyy.takeout.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersServiceImpl implements OrdersService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressBookMapper addressBookMapper;
    @Autowired
    ShoppingCartMapper shoppingCartMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    
    
    @Override
    public boolean submit(Orders orders) {
        
        Long userId=orders.getUserId();
        //1. 获取地址
        AddressBook address = addressBookMapper.getByUserId(userId);
        //2. 获取用户
        User user=userMapper.getById(userId);
        //3. 获取购物车
        List<ShoppingCart> list = shoppingCartMapper.list(userId);
        


        BigDecimal bigDecimal=new BigDecimal(0);
        
        list.stream().map((item)->
        {
            BigDecimal decimal =item.getAmount().multiply(new BigDecimal(item.getNumber()));
            bigDecimal.add(decimal);
            return null;
        }).collect(Collectors.toList());

        orders.setAddressBookId(address.getId());
        orders.setPhone(address.getPhone());
        orders.setAddress(address.getProvinceName()+address.getCityName()+address.getDistrictName());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setAmount(bigDecimal);
        orders.setStatus(2);
        orders.setPayMethod(1);
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setUserName(user.getName());
        orders.setConsignee(address.getConsignee());
        
        
        list.stream().map((item)->
        {
            OrderDetail detail=new OrderDetail();
            detail.setOrderId(orders.getId());
            detail.setNumber(item.getNumber());
            detail.setDishFlavor(item.getDishFlavor());
            detail.setImage(item.getImage());
            detail.setDishId(item.getDishId());
            detail.setSetmealId(item.getSetmealId());
            BigDecimal decimal =item.getAmount().multiply(new BigDecimal(item.getNumber()));
            orderDetailMapper.insert(detail);
            return null;
        }).collect(Collectors.toList());
        
        orderMapper.insert(orders);
        shoppingCartMapper.clean(userId);
        return true;

    }
}
