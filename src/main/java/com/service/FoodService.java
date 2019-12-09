package com.service;


import com.bean.Food;
import com.github.pagehelper.PageInfo;

/**
 * @author 下一张幸福
 */
public interface FoodService {

    /**
     * 获取食物列表
     * @param pageNum 页
     * @param pageSize 每页大小
     * @param key 关键字
     * @param sort 排序 -1:降序;1;升序
     * @param classify 分类 0:全部
     * @return 页的相关信息
     */
    PageInfo<Food> getFoodPage(int pageNum, int pageSize, String key, int sort,int classify);
}
