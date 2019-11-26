package com.service;

import com.bean.Users;

/**
 * @author 下一张幸福
 */
public interface UsersService {
    /**
     * 登录
     * @param users 登录信息
     * @return 登录后账号信息
     */
    Users login(Users users);

    /**
     * 注册
     * @param users 注册基本信息
     * @return 注册后账号信息
     */
    Users register(Users users);
}
