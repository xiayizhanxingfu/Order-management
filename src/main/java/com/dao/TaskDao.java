package com.dao;

import com.bean.Orderform;
import com.bean.Task;
import com.bean.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 下一张幸福
 */
public interface TaskDao {
    /**
     * 添加任务
     *
     * @param tasks 任务列表
     * @param users 用户信息
     */
    void insertAll(@Param("list") List<Orderform> tasks, @Param("users") Users users);


    /**
     * 查询任务列表
     *
     * @param taskStatus      任务状态 0:未领取;1:己领取,正在做;2:完成
     * @param orderformStatus 订单状态 0:未付款;1:己付款;2:未上菜;3:完成交易
     * @param functionary     厨师负责人 默认无
     * @return
     */
    List<Task> selectTask(@Param("taskStatus") int taskStatus, @Param("orderformStatus") int orderformStatus, @Param("functionary") String functionary);

    /**
     * 更新任务属性
     *
     * @param status      状态 0:为领取;1:己领取,正在做;2:完成
     * @param functionary 负责人,默认为无
     * @param id          用户的订单列表
     * @return
     */
    int updateTask(@Param("status") int status, @Param("functionary") String functionary, @Param("orderId") int[] id);
}
