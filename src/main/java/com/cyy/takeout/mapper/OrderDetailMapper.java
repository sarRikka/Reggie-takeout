package com.cyy.takeout.mapper;

import com.cyy.takeout.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
    
    public boolean insert(OrderDetail orderDetail);
    
}
