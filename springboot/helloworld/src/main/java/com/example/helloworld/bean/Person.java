/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.example.helloworld.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @authur wtj
 * @date 2019/7/29    18:16
 */

/**
 * 将配置文件中配置的每一个属性的值映射到对象中
 * @ConfigurationProperties ：告诉SpringBoot将本类中的所有属性与配置文件中的相关配置进行绑定；
 *      prefix = "person":配置文件中那个标签下面的所有属性进行映射
 *      默认从全局配置文件获取值
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties 功能；
 */
@Component
@ConfigurationProperties(prefix = "person" )
//@PropertySource(value = "classpath:person.properties") //读取非全局的配置文件
public class Person {

    /**
     * <bean class="Person">
     *      <property name="name" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * </bean>
     *
     */
//    @Value("${person.name}")
    private String name;
//    @Value("#{2*18}")
    private Integer age;
    private Boolean bossFlag;
    private Date birth;
    private Map<String,Object> map;
    private List<Object> list;
    private Dog dog;

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

    public Boolean getBossFlag() {
        return bossFlag;
    }

    public void setBossFlag(Boolean bossFlag) {
        this.bossFlag = bossFlag;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bossFlag=" + bossFlag +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }


}
