package com.service.impl;

import com.bean.Orderform;
import com.bean.Task;
import com.bean.Users;
import com.dao.OrderformDao;
import com.dao.TaskDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<Task> getTask(int page) {
        PageHelper.startPage(page, 9);
        PageInfo<Task> pageInfo = new PageInfo<>(taskDao.selectTask(0,1,"无"));
        return pageInfo;
    }

    @Override
    public void getTask(Users users,int[] id) {
        taskDao.updateTask(1, users.getUserName(), id);
    }

    @Override
    public void cancelTask(Users users, int[] id) {
        taskDao.updateTask(0, "无", id);
    }

    @Override
    public void doneTask(Users users, int[] id) {
        taskDao.updateTask(2,users.getUserName(),id);
    }

    @Override
    public PageInfo<Task> getWaiterTask(int page) {
        PageHelper.startPage(page, 9);
        PageInfo<Task> pageInfo = new PageInfo(taskDao.selectTask(2,2,""));
        return pageInfo;
    }

    @Override
    public PageInfo<Task> getMyTask(Users users,int page) {
        PageHelper.startPage(page, 9);
        PageInfo<Task> pageInfo = new PageInfo<>(taskDao.selectTask(1,2,""));
        return pageInfo;
    }

}
