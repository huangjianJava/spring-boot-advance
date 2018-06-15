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

    /**
     * direct exchange
     * @param message
     */
    @RabbitListener(queues = "amqpdirect.queue")
    public void receiveDirect(Message message){
        System.out.println("========== direct-监听接收 ==========");
        String msg = new String(message.getBody());
        System.out.println(msg);
        System.out.println(message);
    }

    /**
     * fanout exchange
     * @param message
     */
    @RabbitListener(queues = "amqpfanout.queue1")
    public void receiveFanoutOne(Message message){
        System.out.println("========== fanout1-监听接收 ==========");
        String msg = new String(message.getBody());
        System.out.println(msg);
        System.out.println(message);
    }

    /**
     * fanout exchange
     * @param message
     */
    @RabbitListener(queues = "amqpfanout.queue2")
    public void receiveFanoutTwo(Message message){
        System.out.println("========== fanout2-监听接收 ==========");
        String msg = new String(message.getBody());
        System.out.println(msg);
        System.out.println(message);
    }

}
