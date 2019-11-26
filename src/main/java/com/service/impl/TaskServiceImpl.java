package com.service.impl;

import com.bean.Orderform;
import com.bean.Task;
import com.bean.Users;
import com.dao.OrderformDao;
import com.dao.TaskDao;
import com.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 下一张幸福
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    TaskDao taskDao;
    @Resource
    OrderformDao orderformDao;

    @Override
    public void addTask(List<Orderform> list,Users users) {
        //根据订单编号获取,食物编号和数量
        List<Orderform> foods = orderformDao.selectFoodIdAndSize(list);
        taskDao.insertAll(foods,users);
    }

    @Override
    public List<Task> getTask() {
        return taskDao.selectAll();
    }

    @Override
    public void getTask(Users users,int id) {
        taskDao.updateGetTask(users,id);
    }

    @Override
    public void cancelTask(Users users, int id) {
        taskDao.updateCancelTask(users, id);
    }

    @Override
    public void doneTask(Users users, int id) {
        taskDao.updateDoneTask(users,id);
    }

    @Override
    public List<Orderform> getWaiterTask() {
        return taskDao.selectAllByStatus(2);
    }

}
