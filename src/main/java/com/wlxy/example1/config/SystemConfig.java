package com.wlxy.example1.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义配置文件实体类
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class SystemConfig {
    private String info;
    private String author;
    private String email;

    private String swaggerTitle;     //页面的标题
    private String swaggerContactName;    //创始人的名字
    private String swaggerContactWebUrl;   //浏览器地址
    private String swaggerContactEmail;    //email
    private String swaggerVersion;         //版本号
    private String swaggerDescription;     //描述
    private String swaggerTermsOfServiceUrl;
}
