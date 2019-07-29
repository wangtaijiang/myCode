/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.configdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authur wtj
 * @date 2019/7/29    22:55
 */
@RestController
public class HiController {

    @RequestMapping("hi")
    public String hi(){
        return "hi";
    }
}
