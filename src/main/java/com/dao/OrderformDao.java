package com.dao;


import com.bean.Orderform;
import com.bean.Task;
import com.bean.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 下一张幸福
 */
public interface OrderformDao {
    /**
     * 插入订单
     *
     * @param list 订单信息
     */
    void insert(List<Orderform> list);

    /**
     * 获取所有订单信息
     *
     * @param users 用户信息
     * @param key 关键字
     * @param sort 排序>0升序;<0降序
     * @param status 订单状态 -1:全部;0:未付款;1:己付款;2:未上菜
     * @return 订单信息
     */
    List<Orderform> selectAll(@Param("users") Users users, @Param("key") String key, @Param("sort") int sort, @Param("status") int status);

    /**
     * 付款
     *
     * @param list  订单信息
     * @param users 用户信息
     */
    void updateStatutList(@Param("list") List<Orderform> list, @Param("users") Users users);

    /**
     * 修改订单状态
     * @param id 订单列表
     * @param status 订单状态
     */
    void updateStatut(@Param("id") int[] id, @Param("status") int status);

    /**
     * 获取食物编号和数量
     *
     * @param list 订单id列表
     * @return 结果
     */
    List<Orderform> selectFoodIdAndSize(List<Orderform> list);
}
