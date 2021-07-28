package com.naruto.mengzhiayuan.service;

import com.naruto.mengzhiayuan.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User checkUser(String username,String password);
}
