/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @authur wtj
 * @date 2019/8/2    13:05
 */
@Service
public class ScheduleService {

    /**
     * second,minute,hour,day of month,month,day of week.
     * 示例：0 * * * * MON-FRI
     * 星期写法：0-7或者SUN-SAT 0,7都代表SUN  有别于quartz的写法
     * [0 0/5 14,18 * * ?] 每天14点和18点整 ，每隔分钟执行一次
     * [0 15 10 ？ * 1-6] 每个月周一到周六 10:15分执行一次
     * [0 0 2 ？ * 6L]每个月最后一个周六凌晨2点执行一次
     * [0 0 2 LW * ？]每个月最后一个工作日凌晨2点执行一次
     * [0 0 2-4 ？ * 1#1]每个月的第一个周一 凌晨2点到4点每个整点执行一次
     */
//    @Scheduled(cron = "0 * * * * MON-FRI")
//    @Scheduled(cron = "0,1,2,3,4,5 * * * * MON-FRI")//逗号分隔，枚举写法
//    @Scheduled(cron = "0-5 * * * * MON-FRI")//-分隔，区间写法
//    @Scheduled(cron = "0/5 * * * * MON-FRI") //每五秒执行一次
    @Scheduled(cron = "0/5 * * * * MON-FRI")
    public void hello(){
        System.out.println("hello wold");
    }
}
