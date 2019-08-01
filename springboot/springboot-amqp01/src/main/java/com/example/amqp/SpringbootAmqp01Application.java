package com.example.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 *  1、RabbitAutoConfiguration
 *  2、有自动配置了连接工厂    CachingConnectionFactory；
 *  3、RabbitProperties 封装了RabbitMQ的配置
 *  4、RabbitTemplate：给RabbitMQ发送和接收消息
 *  5、AmqpAdmin:RabbitMQ系统管理功能组件 声明队列、创建交换器。。。
 *      AmqpAdmin:
 *  6、@EnableRabbit + @RabbitListener 监听消息队列的消息
 *
 */
@EnableRabbit //开启基于注解的RabbitMQ 如：使@RabbitListener注解 生效
@SpringBootApplication
public class SpringbootAmqp01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAmqp01Application.class, args);
    }

}
