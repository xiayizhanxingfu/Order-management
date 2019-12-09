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

    /**
     * 获取所有任务列表
     *
     * @param session 会话
     * @return 结果
     */

    @ResponseBody
    @RequestMapping(value = "/taskList", produces = {"application/json;charset=utf-8"})
    public String taskList(HttpSession session,
                           @RequestParam("page") int page) {
        Map<String, Object> map = new HashMap<>(3);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            map.put("status", "ok");
            map.put("pageinfo", taskService.getWaiterTask(page));
        }
        return JSON.toJSONString(map);
    }

    //上菜
    @ResponseBody
    @RequestMapping(value = "/done", produces = {"application/json;charset=utf-8"})
    public String doneTask(HttpSession session,
                           @RequestParam("id[]") int[] id) {
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
