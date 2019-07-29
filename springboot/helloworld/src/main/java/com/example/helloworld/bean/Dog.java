/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.helloworld.bean;

/**
 * @authur wtj
 * @date 2019/7/29    18:18
 */
public class Dog {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
