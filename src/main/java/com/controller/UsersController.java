package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.Users;
import com.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {
    @Resource
    UsersService usersService;

    /**
     * 登录
     * @param users 登录信息
     * @return 结果
     */
    @ResponseBody
    @RequestMapping(value = "/login", produces = {"application/json;charset=utf-8"})
    public String login(Users users, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(users);
        users = usersService.login(users);
        System.out.println(users);
        if (users == null) {
            map.put("status", "error");
        } else {
            map.put("status", "ok");
            session.setAttribute("userinfo", users);
            map.put("userinfo", users);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 注册账号
     *
     * @param users 注册基本信息
     * @return 注册后的账号
     */
    @ResponseBody
    @RequestMapping("/register")
    public String register(Users users) {
        System.out.println(users);
        users = usersService.register(users);
        Map<String, String> map = new HashMap<>();
        if (users == null) {
            map.put("status", "error");
        } else {
            map.put("status", "ok");
            map.put("account", users.getUserAccount());
        }
        return JSON.toJSONString(map);
    }
}
