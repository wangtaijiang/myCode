package com.example.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.example.cache.entities.Employee;

/**
 * @authur wtj
 * @date 2019/7/31    22:09
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Employee> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        redisTemplate.setDefaultSerializer(serializer);
        return redisTemplate;
    }

//    public RedisCacheManager redisCacheManager(RedisTemplate<Object, Employee> redisTemplate){
//
//        RedisCacheManager redisCacheManager = new RedisCacheManager();
//    }
}
