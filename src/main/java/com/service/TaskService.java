package com.service;

import com.bean.Orderform;
import com.bean.Task;
import com.bean.Users;

import java.util.List;

/**
 * @author 下一张幸福
 */
public interface TaskService {
    /**
     * 添加任务
     * @param list 订单信息
     * @param users 用户信息
     */
    void addTask(List<Orderform> list,Users users);

    /**
     * 获取任务列表
     * @return 任务列表
     */
    List<Task> getTask();
    /**
     * 厨师领取任务
     * @param users 厨师账号
     * @param id 任务编号
     */
    void getTask(Users users,int id);

    /**
     * 取消任务
     * @param users 厨师账号
     * @param id 任务编号
     */
    void cancelTask(Users users, int id);

    /**
     * 完成任务
     * @param users 厨师账号
     * @param id 任务编号
     */
    void doneTask(Users users, int id);

    /**
     * 服务获取任务
     * @return 任务列表
     */
    List<Orderform> getWaiterTask();

}
