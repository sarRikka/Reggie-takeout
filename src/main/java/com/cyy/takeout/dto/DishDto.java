package com.cyy.takeout.dto;

import com.cyy.takeout.entity.Dish;
import com.cyy.takeout.entity.DishFlavor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDto extends Dish implements Serializable {
    
    List<DishFlavor> flavors=new ArrayList<>();
    
    String categoryName;
    
    Integer copies;
    
    
}
