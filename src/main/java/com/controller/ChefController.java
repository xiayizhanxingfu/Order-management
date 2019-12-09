package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.Task;
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
@RequestMapping("/chef")
public class ChefController {
    @Resource
    TaskService taskService;
    @Resource
    OrderformService orderformService;

    /**
     * 获取所有未领取任务列表
     *
     * @param session 会话
     * @return 状态和结果
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
            map.put("pageinfo", taskService.getTask(page));
        }
        return JSON.toJSONString(map);
    }

    /**
     * 获取自己的己领取任务列表
     *
     * @param session 会话
     * @return 状态和结果
     */
    @ResponseBody
    @RequestMapping(value = "/myTaskList", produces = {"application/json;charset=utf-8"})
    public String myTaskList(HttpSession session,
                             @RequestParam("page") int page) {
        Map<String, Object> map = new HashMap<>(3);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            map.put("status", "ok");
            map.put("pageinfo", taskService.getMyTask(users, page));
        }
        return JSON.toJSONString(map);
    }

    /**
     * 厨师领取操作
     *
     * @param session 会话
     * @return 状态
     */
    @ResponseBody
    @RequestMapping(value = "/getTask", produces = {"application/json;charset=utf-8"})
    public String getTask(HttpSession session,
                          @RequestParam("id[]") int[] id) {
        Map<String, Object> map = new HashMap<>(2);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            //修改客户订单状态为未上菜
            orderformService.updateStatut(id, 2);
            taskService.getTask(users, id);
            map.put("status", "ok");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 厨师取消任务操作
     *
     * @param session 会话
     * @param id      任务编号
     * @return 状态
     */
    @ResponseBody
    @RequestMapping(value = "/cancelTask", produces = {"application/json;charset=utf-8"})
    public String calcelTask(HttpSession session,
                             @RequestParam("id[]") int[] id) {
        Map<String, Object> map = new HashMap<>(2);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            taskService.cancelTask(users, id);
            //修个客户订单状态为己付款
            orderformService.updateStatut(id, 1);
            map.put("status", "ok");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 厨师完成任务操作
     *
     * @param session 会话
     * @param id      任务编号
     * @return 状态
     */
    @ResponseBody
    @RequestMapping(value = "/doneTask", produces = {"application/json;charset=utf-8"})
    public String doneTask(HttpSession session,
                           @RequestParam("id[]") int[] id) {
        Map<String, Object> map = new HashMap<>(2);
        Users users = (Users) session.getAttribute("userinfo");
        if (users == null) {
            map.put("status", "error");
        } else {
            taskService.doneTask(users, id);
            map.put("status", "ok");
        }
        return JSON.toJSONString(map);
    }
}
