/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.service.AsyncService;

/**
 * @authur wtj
 * @date 2019/8/2    12:57
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("hello")
    public String sayHello(){
        asyncService.hello();
        return "sayHello success";
    }
}
