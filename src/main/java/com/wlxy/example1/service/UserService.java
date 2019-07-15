package com.wlxy.example1.service;

import com.wlxy.example1.common.PageParam;
import com.wlxy.example1.model.User;

import java.util.List;

public interface UserService {
    Object getAllUser(PageParam<User> pageParam);

    boolean removeUserById(int id);

    Object addUser(User user);

    boolean updateUser(User user);

    User getUserById(int id);
}
