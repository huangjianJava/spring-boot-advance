package com.huangj.advance;

import org.junit.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangj
 * @Description:
 * @date 2018/6/13
 */
public class RabbitMqTest extends BaseTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("amqpadirect.queue");
        System.out.println(o.getClass());
        System.out.println(o);

        System.out.println("========== 获取成功 ==========");
    }

    @Test
    public void send() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第二个消息");
        map.put("data", Arrays.asList("helloworld2",12345,false));
        rabbitTemplate.convertAndSend("amqpadirect.exchange","amqp.test",map);

        System.out.println("========== 发送成功 ==========");
    }

    @Test
    public void createExchange(){
        // 创建一个 Direct Exchange -> 点对点
        amqpAdmin.declareExchange(new DirectExchange("amqpadirect.exchange",true,false));

        // 创建一个 Queue
        amqpAdmin.declareQueue(new Queue("amqpadirect.queue",true));

        // 创建绑定关系
		amqpAdmin.declareBinding(new Binding("amqpadirect.queue", Binding.DestinationType.QUEUE,
                "amqpadirect.exchange","amqp.test",null));

		System.out.println("========== 创建成功 ==========");
    }



}




















