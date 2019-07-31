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
 *              @CachePut
 *
 *  默认使用的是ConcurrentMapCacheManager == ConcurrentMapCache；将数据保存在ConcurrentMap<Object,Object>中
 *  开发中使用的是缓存中间件：redis、MemCache、ehcache
 *
 *  三、整合redis作为缓存
 *  Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 *  1、安装redis：使用docker
 *  2、引入redis的starter
 *  3、配置redis
 *  4、测试缓存
 *      原理：CacheManager===Cache缓存组件来实际给缓存中缓存数据
 *      ①引入redis的starter，容器中保存的是RedisCacheManager
 *      ②RedisCacheManager帮我们创建RedisCache来作为缓存组件；RedisCache来操作redis来缓存数据
 *      ③默认保存数据k-v都是Object；利用序列化保存，如何保存为json
 *          引入redis的starter，CacheManager变为RedisCacheManager；
 *          默认创建的RedisCacheManager操作redis的时候，使用的是RedisTemplate<Object,Object>
 *          RedisTemplate<Object,Object>是默认使用jdk的序列化机制
 *      ④自定义CacheManager；
 */
@SpringBootApplication
@MapperScan("com.example.cache.mapper")
@EnableCaching
public class SpringBootCache01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCache01Application.class, args);
    }

}
