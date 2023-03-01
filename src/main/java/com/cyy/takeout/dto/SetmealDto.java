package com.cyy.takeout.dto;

import com.cyy.takeout.entity.Setmeal;
import com.cyy.takeout.entity.SetmealDish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetmealDto extends Setmeal {
    
    List<SetmealDish> setmealDishes=new ArrayList<>();
    String categoryName;
    
}
