package com.naruto.mengzhiayuan.service.Impl;

import com.naruto.mengzhiayuan.dao.TypeDao;
import com.naruto.mengzhiayuan.pojo.Type;
import com.naruto.mengzhiayuan.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/29 15:35
 */

/*显然声明式事务管理要优于编程式事务管理，这正是spring倡导的非侵入式的开发方式。
*声明式事务管理使业务代码不受污染，一个普通的POJO对象，只要加上@Transational 注解就可以获得完全的事务支持。
*和编程式事务相比，声明式事务唯一不足地方是，后者的最细粒度只能作用到方法级别，无法做到像编程式事务那样可以作用到代码块级别
*
*/

    //后台管理分类
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    //事务注解
    @Transactional
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(long id) {
        return typeDao.getTypeById(id);
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public List<Type> getAdminType() {
        return typeDao.getAdminType();
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional
    @Override
    public int deleteType(long id) {
        return typeDao.deleteType(id);
    }

}
