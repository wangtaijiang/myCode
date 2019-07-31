package com.example.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 * 1、导入数据库文件，创建出department和employee
 * 2、创建javaBean
 * 3、整合Mybatis操作数据库
 *      ①配置数据源信息
 *      ②注解版的Mybatis
 *              @MapperScan指定需要扫描的mapper接口所在的包
 *
 * 二、快速体验缓存
 *      步骤：
 *          1、开启基于注解的缓存
 *          2、标注缓存注解即可
 *              @Cacheable
 *              @CacheEvict
 *              @
 */
@SpringBootApplication
@MapperScan("com.example.cache.mapper")
@EnableCaching
public class SpringBootCache01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCache01Application.class, args);
    }

}
