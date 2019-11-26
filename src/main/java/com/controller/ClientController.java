package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.Food;
import com.bean.Orderform;
import com.bean.Users;
import com.service.FoodService;
import com.service.OrderformService;
import com.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 下一张幸福
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    @Resource
    FoodService foodService;
    @Resource
    OrderformService orderformService;
    @Resource
    TaskService taskService;

    /**
     * 获取食物列表
     *
     * @param session 会话
     * @return 列表
     */
    @ResponseBody
    @RequestMapping(value = "/foodList", produces = {"application/json;charset=utf-8"})
    public String foodList(HttpSession session) {
        Users users = (Users) session.getAttribute("userinfo");
        Map<String, Object> map = new HashMap<>(3);
        List<Food> list;
        if (users == null) {
            map.put("status", "error");
        } else {
            list = foodService.getFoodList();
            map.put("status", "ok");
            map.put("foodList", list);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 添加订单
     *
     * @return 添加状态
     */
    @ResponseBody
    @RequestMapping(value = "/addOrderformList", produces = {"application/json;charset=utf-8"})
    public String addOrderformList(HttpSession session,
                                   @RequestParam("id[]") int[] id) {
        Users users = (Users) session.getAttribute("userinfo");
        Map<String, Object> map = new HashMap<>(2);
        if (users == null) {
            map.put("status", "error");
        } else {
            List<Orderform> list = new ArrayList<>();
            for (int value : id) {
                Orderform orderform = new Orderform();
                Food food = new Food();
                food.setFoodId(value);
                orderform.setFood(food);
                orderform.setUsers(users);
                orderform.setSize(1);
                orderform.setStatus(0);
                list.add(orderform);
            }
            orderformService.add(list);
            map.put("status", "ok");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 获取订单信息
     *
     * @param session 会话
     * @return 订单列表
     */
    @ResponseBody
    @RequestMapping(value = "/orderformList", produces = {"application/json;charset=utf-8"})
    public String orderformList(HttpSession session) {
        Map<String, Object> map = new HashMap<>(3);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            List<Orderform> list = orderformService.getOrderformList(users);
            map.put("status", "ok");
            map.put("orderformList", list);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 客户付款
     *
     * @param session 会话
     * @param id      订单id
     * @return 付款状态
     */
    @ResponseBody
    @RequestMapping(value = "/settleAccounts", produces = {"application/json;charset=utf-8"})
    public String settleAccounts(HttpSession session,
                                 @RequestParam("id[]") int[] id,
                                 @RequestParam("size[]") int[] sizes,
                                 @RequestParam("localtion")String localtion) {
        Map<String, Object> map = new HashMap<>(2);
        Users users = (Users) session.getAttribute("userinfo");
        System.out.println(users);
        if (users == null && id.length != sizes.length) {
            map.put("status", "error");
        } else {
            List<Orderform> list = new ArrayList<>();
            for (int i = 0; i < sizes.length; i++) {
                Orderform orderform = new Orderform();
                orderform.setOrderId(id[i]);
                orderform.setSize(sizes[i]);
                orderform.setLocation(localtion);
                list.add(orderform);
            }
            //修改客户订单状态
            orderformService.payment(list, users);
            //付款成功后,添加订单到任务
            taskService.addTask(list, users);
            map.put("status", "ok");
        }
        return JSON.toJSONString(map);
    }
}
