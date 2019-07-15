package com.wlxy.example1.common;

import lombok.Data;

@Data
public class MyRsp {
    //MyRsp即MyResponse

    private int code;
    private String msg;
    private Object content;

    //带参的构造函数
    public MyRsp(int code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    //不带参的构造函数
    public MyRsp() {
    }

    public static MyRsp wrapper(MyException ex){
        MyRsp myRsp=new MyRsp();
        myRsp.setCode(ex.getCode());
        myRsp.setMsg(ex.getMsg());
        myRsp.setContent(null);
        return myRsp;
    }

    //成功
    public static MyRsp success(Object content){
        MyRsp myRsp = new MyRsp();
        myRsp.setCode(HttpCode.SUCCESS.getCode());
        myRsp.setMsg(HttpCode.SUCCESS.getMsg());
        myRsp.setContent(content);

        return myRsp;
    }

    //失败
    public static MyRsp error(){
        MyRsp myRsp = new MyRsp();
        myRsp.setCode(HttpCode.ERROR.getCode());
        myRsp.setMsg(HttpCode.ERROR.getMsg());
        myRsp.setContent(null);

        return myRsp;
    }

    public MyRsp msg(String msg){  // 自定义msg  链式函数
        this.msg=msg;
        return this;
    }
}
