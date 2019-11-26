package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.Orderform;
import com.bean.Users;
import com.service.OrderformService;
import com.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 下一张幸福
 */
@Controller
@RequestMapping("/waiter")
public class WaiterController {

    @Resource
    TaskService taskService;
    @Resource
    OrderformService orderformService;


    @ResponseBody
    @RequestMapping(value = "/taskList", produces = {"application/json;charset=utf-8"})
    public String taskList(HttpSession session) {
        Map<String, Object> map = new HashMap<>(3);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            List<Orderform> taskList = taskService.getWaiterTask();
            map.put("status", "ok");
            map.put("taskList", taskList);
        }
        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping(value = "/done", produces = {"application/json;charset=utf-8"})
    public String doneTask(HttpSession session,
                           @RequestParam("id") int id) {
        Map<String, Object> map = new HashMap<>(3);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            orderformService.doneTask(id);
            map.put("status", "ok");
        }
        return JSON.toJSONString(map);
    }
}
