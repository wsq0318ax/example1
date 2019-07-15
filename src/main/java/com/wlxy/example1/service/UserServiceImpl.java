package com.wlxy.example1.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlxy.example1.common.PageParam;
import com.wlxy.example1.dao.UserDao;
import com.wlxy.example1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Object getAllUser(PageParam<User> pageParam) {

        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());  //分页的条件 PageNum：第几页  PageSize：每页几条

        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);  //   OrderParams: 排序方法（倒序：desc 正序：asc）
        }
        log.info(pageParam.getOrderParams()+"");

        List<User> userList = userDao.getAllUser(pageParam.getModel());
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }

    /**
     *
     * @param id
     * @return
     * @CacheEvict :将一条或者多条数据从缓存中删除
     */
    //@CacheEvict(value = "users",key = "#p0")
    @Override
    public boolean removeUserById(int id) {
        //log.info("走的是数据库");
        return userDao.removeUserById(id)==1;
    }

    /**
     *
     * @param user
     * @return
     *
     * @CachePut :不管缓存里面有没有，都会将返回的结果加入缓存中
     */
    //@CachePut(value = "users",key = "#p0.id")
    @Override
    public Object addUser(User user) {

        user.setRoleId("general");
        userDao.addUser(user);
        //log.info(user.getId()+"");
        return userDao.getUserById(user.getId());   //  本应该返回的是boolean类型，为了测试@CachePut返回一个User
    }


    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user)==1;
    }

    /**
     *
     * @param id
     * @return
     * @Cacheable 在方法执行前会查看缓存（redis）中是否有数据，如果有就直接返回，
     *            如果没有就会调用下面的方法返回值并存放在缓存（redis）的p0中
     */
    //@Cacheable(key = "#p0",value = "users")
    @Override
    public User getUserById(int id){
        log.info("走的是数据库");
        return userDao.getUserById(id);
    }


}
