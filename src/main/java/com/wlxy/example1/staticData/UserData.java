package com.wlxy.example1.staticData;

import com.wlxy.example1.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    public static List<User> userList;

    static {
        userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("Tom");
         user1.setPassword("123");

        User user2 = new User();
        user2.setUserName("Bob");
        user2.setPassword("456");

        userList.add(user1);
        userList.add(user2);
    }

}
