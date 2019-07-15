package com.wlxy.example1.controller;

import com.wlxy.example1.common.MyRsp;
import com.wlxy.example1.common.PageParam;
import com.wlxy.example1.model.User;
import com.wlxy.example1.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "user模块接口",description = "这是一个用户模块的接口文档")
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    //得到信息
    @ApiOperation("查询所有用户 支持多条件查询")
    @ResponseBody
    @RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
    public Object getAllUser(@RequestBody(required = false) PageParam<User> pageParam) {
        //log.info(pageParam.getPageNum()+"");
        return MyRsp.success(userService.getAllUser(pageParam));
    }

    //删除
    // @PathVariable 将路径中的值映射到参数上
    @RequestMapping(value = "/removeUserById/{id}",method = RequestMethod.GET)
    public Object removeUserById(@PathVariable("id") int id){


        return userService.removeUserById(id)?MyRsp.success(null):MyRsp.error().msg("删除失败");
    }

    //添加
    // @RequestBody 将前端传过来的json数据映射成参数
    @PostMapping("/addUser")
    public Object addUser(@RequestBody @Valid User user){
        User u = (User) userService.addUser(user);
        return u!=null?MyRsp.success(null):MyRsp.error().msg("删除失败");
    }


    //修改
    @PutMapping("/updateUser")
    public Object updateUser(@RequestBody User user){

        return userService.updateUser(user)?MyRsp.success(null):MyRsp.error().msg("删除失败");
    }

    //按id查询用户信息
    @GetMapping("/getUserById")
    public Object getUserById(int id){

        User user1 = userService.getUserById(id);
        return user1!=null?MyRsp.success(user1):MyRsp.error().msg("按id查询失败");
    }
}
