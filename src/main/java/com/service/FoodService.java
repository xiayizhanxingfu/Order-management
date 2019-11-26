package com.service;


import com.bean.Food;

import java.util.List;

/**
 * @author 下一张幸福
 */
public interface FoodService {

    /**
     * 获取食物列表
     * @return 结果
     */
    List<Food> getFoodList();
}
