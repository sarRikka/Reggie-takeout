package com.cyy.takeout.service.Impl;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.ShoppingCart;
import com.cyy.takeout.mapper.ShoppingCartMapper;
import com.cyy.takeout.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartMapper shoppingCartMapper;
    
    @Override
    public ShoppingCart add(ShoppingCart shoppingCart, Long UserId) {
        shoppingCart.setUserId(UserId);
        ShoppingCart cart = shoppingCartMapper.getOne(shoppingCart);
        if(cart == null)
        {
            shoppingCart.setNumber(1);
            shoppingCartMapper.add(shoppingCart);
            return shoppingCart;
        }
        else 
        {
            cart.setNumber(cart.getNumber()+1);
            cart.setAmount(cart.getAmount().add(shoppingCart.getAmount()));
            shoppingCartMapper.update(cart);
        }
        return cart;
    }

    @Override
    public List<ShoppingCart> list(Long userId) {
        return shoppingCartMapper.list(userId);
    }

    @Override
    public boolean clean(Long userId) {
        return shoppingCartMapper.clean(userId);
    }
}
