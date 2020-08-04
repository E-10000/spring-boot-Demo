package com.qiang.service;

import com.qiang.Bean.Person;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Person person){
        System.out.println("收到消息"+person);
    }

    @RabbitListener(queues = "atguigu")
    public void receive2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
