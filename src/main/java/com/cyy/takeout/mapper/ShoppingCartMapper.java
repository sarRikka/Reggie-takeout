package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    public boolean add(ShoppingCart shoppingCart);

    public List<ShoppingCart> list(Long userId);

    public boolean clean(Long userId);
    
    public boolean update(ShoppingCart shoppingCart);
    
    public ShoppingCart getOne(ShoppingCart shoppingCart);
}
