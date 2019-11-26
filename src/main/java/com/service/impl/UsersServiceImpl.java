package com.service.impl;

import com.bean.Users;
import com.dao.UsersDao;
import com.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 下一张幸福
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersDao usersDao;

    @Override
    public Users login(Users users) {
        return usersDao.login(users);
    }

    @Override
    public Users register(Users users) {
        Users usersLast = usersDao.selectByLast();
        String account = usersLast.getUserAccount();
        account = String.valueOf(Integer.parseInt(account) + 1);
        users.setUserAccount(account);
        if (usersDao.insert(users) < 0) {
            users = null;
        }
        return users;
    }
}
