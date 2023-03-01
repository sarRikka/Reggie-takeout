package com.cyy.takeout.service;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.ShoppingCart;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ShoppingCartService {

    public ShoppingCart add(ShoppingCart shoppingCart, Long UserId);
    
    public List<ShoppingCart> list(Long userId);
    
    public boolean clean(Long userId);
    
}
