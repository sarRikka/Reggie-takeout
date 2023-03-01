package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    
    public boolean insert(Orders orders);
    
}
