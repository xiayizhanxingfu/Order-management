package com.service;

import com.bean.Food;

import java.util.List;

/**
 * @author 下一张幸福
 */
public interface FoodclassifyService {
    /**
     * 根据食物分类获取食物列表
     * @return
     */
    List<Food> getFoodListByFoodclassify();
}
