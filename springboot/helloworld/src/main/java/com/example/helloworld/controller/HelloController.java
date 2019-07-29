/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authur wtj
 * @date 2019/7/29    15:13
 */
//这个类的所有方法返回的数据直接写给浏览器，（如果是对象转换为json格式）
@RestController
//@Controller
//@ResponseBody
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "Hello World!";
    }
}
