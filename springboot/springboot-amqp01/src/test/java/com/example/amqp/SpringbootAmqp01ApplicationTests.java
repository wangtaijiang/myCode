package com.example.amqp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.amqp.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqp01ApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个，定义消息体内容和消息头
//        Message
//        rabbitTemplate.send(exchange,routeKey,msg);

        //object默认当成消息体，只需要传入需要发送的对象 ，自动序列化发送给RabbitMQ
//        rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","first msg!");
        map.put("data", Arrays.asList("hehe",123,true));
        //1.对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","sanguo.news",map);
        //2、如何将数据以json形式发送出去
            //解决：自定义MessageConverter = new Jackson2JsonMessageConverter();
        rabbitTemplate.convertAndSend("exchange.direct","sanguo.news",new Person("张三",18));
    }

    //接收数据
    @Test
    public void receive(){

        Object o = rabbitTemplate.receiveAndConvert("sanguo.news");
        System.out.println(o.getClass());//class java.util.HashMap
        System.out.println(o);//  {msg=first msg!, data=[hehe, 123, true]}

        System.out.println(o.getClass());//class com.example.amqp.bean.Person
        System.out.println(o);// Person{name='张三', age=18}

    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Person("王五",14));
    }
    @Test
    public void testCreateExchange(){
//        amqpAdmin.declare...;//创建相应的exchange、queue、Binding
//        amqpAdmin.delete..;//删除相应的exchange、queue、Binding
        //创建Exchange
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //创建Queue
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //绑定Exchange 和 Queue，创建绑定规则
//        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange",
//                "amqp.hehe",null));

        System.out.println("创建完成");
    }
}
