package com.service.impl;

import com.bean.Orderform;
import com.bean.Task;
import com.bean.Users;
import com.dao.OrderformDao;
import com.dao.TaskDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.OrderformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public PageInfo<Orderform> getOrderformList(int pageNum, String key, int sort, int status, Users users) {
        PageHelper.startPage(pageNum, 9);
        List<Orderform> list = orderformDao.selectAll(users,key,sort,status);
        PageInfo<Orderform> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void payment(List<Orderform> list, Users users) {
        orderformDao.updateStatutList(list, users);
    }

    @Override
    public void doneTask(int[] id) {
        orderformDao.updateStatut(id, 3);
    }

    @Override
    public void updateStatut(int[] id, int status) {
        orderformDao.updateStatut(id, status);
    }
}
