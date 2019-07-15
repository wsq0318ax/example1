package com.wlxy.example1.common;

public enum HttpCode {

    //错误信息提示 成功/失败
    SUCCESS( 200,"访问成功"),
    ERROR( 500,"服务器出小差了。。。。"),
    NOT_FOUND(404,"查询不出数据了。。。。");


    private int code;
    private String msg;

    public int getCode(){
        return this.code;
    }
    public String getMsg(){
        return this.msg;
    }

    //构造函数
    HttpCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
