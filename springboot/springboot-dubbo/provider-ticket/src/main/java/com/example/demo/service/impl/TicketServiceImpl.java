/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.demo.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.example.demo.service.TicketService;

/**
 * @authur wtj
 * @date 2019/8/2    18:50
 */
@Service//将服务发布出去
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "厉害了，小老弟！";
    }
}
