/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.amqp.bean.Person;

/**
 * @authur wtj
 * @date 2019/8/1    16:51
 */
@Service
public class BookService {

    @RabbitListener(queues = "sanguo.news")
    public void recerve(Person person){

        System.out.println("收到消息：" + person);
    }

    @RabbitListener(queues = "sanguo")
    public void receive2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
