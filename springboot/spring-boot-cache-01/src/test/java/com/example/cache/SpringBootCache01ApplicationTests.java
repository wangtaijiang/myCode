package com.example.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cache.entities.Employee;
import com.example.cache.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCache01ApplicationTests {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串
    @Autowired
    RedisTemplate redisTemplate;// k - v 都是对象
    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;
    @Test
    public void contextLoads() {


    }

    @Test
    public void testCacheable(){
        System.out.println(employeeService.getEMP(2));

        System.out.println(employeeService.getEMP(1));
        System.out.println(employeeService.getEMP(1));
    }
    @Test
    public void testCachePut(){
        Employee employee = new Employee();
        employee.setLastName("zhangsan");
        employee.setGender(0);

    }
    @Test
    public void testCacheEvict(){

        employeeService.deleteEMP(1);

    }

    /**
     * redis常见五大数据类型
     * String（字符串）/List（列表）/Set（集合）/Hsah（散列）/Zset（有序集合）
     *         stringRedisTemplate.opsForValue();String（字符串）
     *         stringRedisTemplate.opsForList();List（列表）
     *         stringRedisTemplate.opsForSet();Set（集合）
     *         stringRedisTemplate.opsForHash();Hsah（散列）
     *         stringRedisTemplate.opsForZSet();Zset（有序集合）
     */
    @Test
    public void testStringRedisTemplate(){
        //向redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        System.out.println(stringRedisTemplate.opsForList().leftPop("mylist"));

        //        stringRedisTemplate.opsForList();
//        stringRedisTemplate.opsForSet();
//        stringRedisTemplate.opsForHash();
//        stringRedisTemplate.opsForZSet();
    }

    //测试保存对象
    @Test
    public void testRedisTemplate(){
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        redisTemplate.opsForValue().set("emp01",employeeService.getEMP(1));
        System.out.println(redisTemplate.opsForValue().get("emp01"));
        //1、将数据以json的方式保存到redis
            //①自己将对象转换为json格式
            //②redisTemplate默认的序列化规则

        employeeRedisTemplate.opsForValue().set("emp02",employeeService.getEMP(2));
//        System.out.println(employeeRedisTemplate.opsForValue().get("emp02"));
        System.out.println("================");
    }

}
