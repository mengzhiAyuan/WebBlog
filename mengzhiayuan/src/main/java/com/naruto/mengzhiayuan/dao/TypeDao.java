package com.naruto.mengzhiayuan.dao;


import com.naruto.mengzhiayuan.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//从mybatis3.4.0开始加入了@Mapper注解，目的就是为了不再写mapper映射文件
//如上图代码：使用@Mapper注解要定义成一个接口interface
//1.使用@Mapper将此接口交给Spring进行管理
//
//2.不用写Mapper映射文件（XML）
//
//3.为这个此接口生成一个实现类，让别的类进行引用

@Mapper
@Repository
public interface TypeDao {

    int saveType(Type type);

    Type getTypeById(Long id);

    Type getTypeByName(String name);

    List<Type> getAllType();

    List<Type> getAdminType();

    int deleteType(Long id);

    int updateType(Type type);


}
