package com.naruto.mengzhiayuan.service.Impl;

import com.naruto.mengzhiayuan.dao.UserDao;
import com.naruto.mengzhiayuan.pojo.User;
import com.naruto.mengzhiayuan.service.UserService;
import com.naruto.mengzhiayuan.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/28 15:48
 */

//检查博客名是否存在
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
