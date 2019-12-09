package com.test;

import com.bean.Task;
import com.bean.Users;
import com.dao.TaskDao;
import com.github.pagehelper.PageInfo;
import com.service.FoodService;
import com.service.OrderformService;
import com.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MainTest {
    @Resource
    FoodService foodService;
    @Resource
    OrderformService orderformService;
    @Resource
    TaskService taskService;
    @Resource

    @Test
    public void text1() {

    }
}
