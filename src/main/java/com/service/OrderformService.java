package com.service;

import com.bean.Orderform;
import com.bean.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 下一张幸福
 */
public interface OrderformService {
    /**
     * 添加订单
     *
     * @param list 订单列表
     */
    void add(List<Orderform> list);

    /**
     * 获取订单
     *
     * @param users 用户信息
     * @return 订单列表
     */
    List<Orderform> getOrderformList(Users users);

    /**
     * 修改订单状态
     *
     * @param id     任务编号
     * @param status 订单状态
     */
    void updateStatut(@Param("id") int id, @Param("status") int status);

    /**
     * 付款
     *
     * @param list  订单星系列表
     * @param users 用户信息
     */
    void payment(List<Orderform> list, Users users);

    /**
     * 完成交易
     *
     * @param id 订单编号
     */
    void doneTask(int id);
}
