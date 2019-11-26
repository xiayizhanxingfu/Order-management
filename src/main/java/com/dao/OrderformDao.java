package com.dao;


import com.bean.Orderform;
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
     * @return 订单信息
     */
    List<Orderform> selectAll(Users users);

    /**
     * 付款
     *
     * @param list  订单信息
     * @param users 用户信息
     */
    void updateStatutList(@Param("list") List<Orderform> list, @Param("users") Users users);

    /**
     * 修改订单状态
     * @param id 订单id
     * @param status 订单状态
     */
    void updateStatut(@Param("id") int id, @Param("status") int status);

    /**
     * 获取食物编号和数量
     *
     * @param list 订单id列表
     * @return 结果
     */
    List<Orderform> selectFoodIdAndSize(List<Orderform> list);
}
