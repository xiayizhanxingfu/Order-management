package com.dao;

import com.bean.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 下一张幸福
 */
@Repository
public interface FoodclassifyDao {
    /**
     * 根据食物分类获取食物列表
     *
     * @return 结果
     */
    List<Food> selectAllByFoodclassify();
}
