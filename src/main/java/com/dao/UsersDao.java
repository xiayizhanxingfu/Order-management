package com.dao;

import com.bean.Users;
import org.springframework.stereotype.Repository;

/**
 * @author 下一张幸福
 */
@Repository
public interface UsersDao {
    /**
     * 登录
     * @param users 登录信息
     * @return 存在记录的信息
     */
    Users login(Users users);

    /**
     * 添加一个账号
     * @param users 账号信息
     * @return 影响行数
     */
    int insert(Users users);

    /**
     * 获取最后一条记录
     * @return 最后一行数据
     */
    Users selectByLast();
}
