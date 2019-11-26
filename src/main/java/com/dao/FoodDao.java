package com.dao;

import com.bean.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 下一张幸福
 */
@Repository
public interface FoodDao {
    /**
     * 食物列表
     * @return 返回所有记录
     */
    List<Food> selectAll();
}
