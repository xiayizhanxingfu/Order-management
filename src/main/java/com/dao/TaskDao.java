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
     * @param tasks 任务列表
     * @param users 用户信息
     */
    void insertAll(@Param("list") List<Orderform> tasks,@Param("users") Users users);

    /**
     * 获取任务列表
     * @return 任务列表
     */
    List<Task> selectAll();

    /**
     * 领取任务
     * @param users 厨师信息
     * @param id 任务编号
     */
    void updateGetTask(@Param("users") Users users, @Param("id") int id);

    /**
     * 取消任务
     * @param users 厨师信息
     * @param id 任务编号
     */
    void updateCancelTask(@Param("users") Users users, @Param("id") int id);

    /**
     * 完成任务
     * @param users 厨师账号
     * @param id 任务编号
     */
    void updateDoneTask(@Param("users") Users users, @Param("id") int id);

    /**
     * 获取订单id
     * @param id 任务id
     * @return 结果
     */
    int getOrderId(int id);

    /**
     * 获取 status 的信息
     * @param status 状态
     * @return 结果
     */
    List<Orderform> selectAllByStatus(int status);
}
