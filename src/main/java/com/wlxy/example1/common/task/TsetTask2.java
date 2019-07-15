package com.wlxy.example1.common.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component        // 将这个类实例化
@Configuration    // 用于标记配置类，兼备Component的效果
@EnableScheduling // 标志着下面可以使用定时任务了
@Slf4j            //使用日志的注解

/**
 * 动态定时任务：就是在代码里面写好了，只能通过修改代码，并重启项目才可以重新定时
 */
public class TsetTask2 {


   //@Scheduled(cron = "5 * * * * ?") // 直接指定时间间隔，或者是具体的时间
   //@Scheduled(fixedDelay = 5000)     //延迟五秒
    //@Scheduled(fixedRate = 5000)
    public void Task1(){
        log.info("Task1开启任务了");
    }


}
