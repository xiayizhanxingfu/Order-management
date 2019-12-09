package com.dao;

import com.bean.Food;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 下一张幸福
 */
@Repository
public interface FoodDao {
    /**
     * 食物列表
     *
     * @param key  关键字
     * @param sort 排序 -1:降序;1;升序
     * @param classify 食物分类 0全部
     * @return 返回所有记录
     */
    List<Food> selectAll( @Param("key") String key, @Param("sort") int sort,@Param("foodClassify") int classify);

}
