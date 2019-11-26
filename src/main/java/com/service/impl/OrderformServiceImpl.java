package com.service.impl;

import com.bean.Orderform;
import com.bean.Users;
import com.dao.OrderformDao;
import com.dao.TaskDao;
import com.service.OrderformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 下一张幸福
 */
@Service
public class OrderformServiceImpl implements OrderformService {
    @Resource
    OrderformDao orderformDao;
    @Resource
    TaskDao taskDao;

    @Override
    public void add(List<Orderform> list) {
        orderformDao.insert(list);
    }

    @Override
    public List<Orderform> getOrderformList(Users users) {
        return orderformDao.selectAll(users);
    }

    @Override
    public void payment(List<Orderform> list, Users users) {
        orderformDao.updateStatutList(list, users);
    }

    @Override
    public void doneTask(int id) {
        orderformDao.updateStatut(id, 3);
    }

    @Override
    public void updateStatut(int id,int status) {
        //根据任务编号获取订单编号
        id = taskDao.getOrderId(id);
        orderformDao.updateStatut(id,status);
    }
}
