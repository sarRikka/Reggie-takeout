package com.cyy.takeout.controller;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.ShoppingCart;
import com.cyy.takeout.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    
    @Autowired
    ShoppingCartService service;
    
    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart, HttpServletRequest request)
    {
        Long userId= (long)request.getSession().getAttribute("user");
        return R.success(service.add(shoppingCart,userId));
    }
    
    @GetMapping("/list")
    public R<List<ShoppingCart>> list(HttpServletRequest request)
    {
        Long userId= (long)request.getSession().getAttribute("user");
        return R.success(service.list(userId));
    }
    
    @DeleteMapping("/clean")
    public R<String> clean(HttpServletRequest request)
    {
        Long userId= (long)request.getSession().getAttribute("user");
        service.clean(userId);
        return R.success("购物车清除成功");
    }
    
}
