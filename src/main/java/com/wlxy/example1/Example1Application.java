package com.wlxy.example1;

import com.wlxy.example1.config.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Example1Application {

    public static void main(String[] args) { SpringApplication.run(Example1Application.class, args);
    }

    @Value("${app.info}")
    private String appInfo;

//    @Autowired
//    private Environment environment;
    @Autowired
    SystemConfig systemConfig;

    @ResponseBody
    @RequestMapping(value="hello" ,method = RequestMethod.GET)
    public String hello() {
//       System.out.println(1/0);
       return systemConfig.toString();
    }

}
