package com.naruto.mengzhiayuan.service;

import com.naruto.mengzhiayuan.pojo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

//后台分类管理
@Service
public interface TypeService {

    //保存分类
    int saveType(Type type);

    Type getType(long id);

    List<Type> getAllType();

    List<Type> getAdminType();

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteType(long id);

}
