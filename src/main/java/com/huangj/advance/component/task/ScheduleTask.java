package com.huangj.advance.component.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author huangj
 * @Description:    统一的定时任务处理类
 * @date 2018/6/15
 */
@Component
public class ScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Scheduled(cron = "0 0 10 ? * MON")
    public void schedulePrint() {
        System.out.println("首先你得热爱生活");
    }

}
