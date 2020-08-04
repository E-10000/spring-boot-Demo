package com.qiang;

import com.qiang.Bean.Person;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
//        rabbitTemplate.send(String exchange, String routeKey, Message var3)
//        Message(byte[] body, MessageProperties messageProperties)  Message为一个数组和一个头消息

//        convertAndSend(String var1, String var2, Object var3)
//        其中，Object var3默认为消息体，会自动序列化发送过去的
//        Map<String,Object> map = new HashMap<>();
//        map.put("msg","这是一个信息");
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",new Person("小强",22));

    }

    @Test
    public void test(){
        Message receive = rabbitTemplate.receive("atguigu.news");
        System.out.println(receive.getClass());
        System.out.println(receive);
    }


    @Test
    public void create(){

        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));

        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.test",null));

    }
}
