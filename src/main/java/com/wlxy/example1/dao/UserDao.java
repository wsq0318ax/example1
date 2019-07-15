package com.wlxy.example1.dao;

import com.wlxy.example1.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

   // @Select("select * from user")
    List<User> getAllUser(User user);

    //@Delete("delete from user where id=#{id}")
    int removeUserById(int id);

    //@Insert("insert into user (userName,password,roleId) values(#{userName},#{password},#{roleId})")
    int addUser(User user);

    //@Update("update user set userName=#{userName},password=#{password} where id=#{id}")
    int updateUser(User user);

    @Select("select * from user where id=#{id}")
    User getUserById(int id);
}
