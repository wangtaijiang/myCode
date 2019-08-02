/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @authur wtj
 * @date 2019/8/2    12:54
 */
@Service
public class AsyncService
{

    //告诉Spring这是一个异步方法，同时要在主类上加@EableAsync
    @Async
    public void hello() {
        System.out.println("处理数据中。。。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
