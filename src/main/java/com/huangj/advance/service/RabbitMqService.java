package com.huangj.advance.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Map;

/**
 * Author: huangj
 * Description: RabbitMq 监听测试 service
 * Date: 2018/6/13
 */
@Service
public class RabbitMqService {

    @RabbitListener(queues = "amqpadirect.queue")
    public void receiveStores(Map<String,Object> map){
        System.out.println("========== 监听接收 ==========");

        System.out.println(map);
    }

}
