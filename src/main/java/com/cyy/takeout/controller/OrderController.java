package com.cyy.takeout.controller;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.Orders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @RequestMapping("/submit")
    public R<String> submit(@RequestBody Orders orders, HttpServletRequest request)
    {
        orders.setUserId((long)request.getSession().getAttribute("user"));
        return R.success("支付订单成功");
    }
    
}
