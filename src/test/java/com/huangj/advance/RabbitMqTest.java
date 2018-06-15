package com.huangj.advance;

import com.huangj.advance.mapper.StoreInfoTkMapper;
import com.huangj.advance.model.StoreInfoModel;
import org.junit.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    StoreInfoTkMapper storeInfoTkMapper;

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("amqpadirect.queue");
        System.out.println(o.getClass());
        System.out.println(o);

        System.out.println("========== 获取成功 ==========");
    }

    @Test
    public void sendFanout() {
        List<StoreInfoModel> models = storeInfoTkMapper.selectAll();
        rabbitTemplate.convertAndSend("amqpfanout.exchange","",models);

        System.out.println("========== 发送成功 ==========");
    }

    @Test
    public void send() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第二个消息");
        map.put("data", Arrays.asList("helloworld2",12345,false));
        rabbitTemplate.convertAndSend("amqpdirect.exchange","amqp.test",map);

        System.out.println("========== 发送成功 ==========");
    }

    @Test
    public void createDirectExchange(){
        // 创建一个 Direct Exchange -> 点对点
        amqpAdmin.declareExchange(new DirectExchange("amqpdirect.exchange",true,false));

        // 创建一个 Queue
        amqpAdmin.declareQueue(new Queue("amqpdirect.queue",true));

        // 创建绑定关系
		amqpAdmin.declareBinding(new Binding("amqpdirect.queue", Binding.DestinationType.QUEUE,
                "amqpdirect.exchange","amqp.test",null));

		System.out.println("========== 创建成功 ==========");
    }

    @Test
    public void createFanoutExchange(){
        // 创建一个 Fanout Exchange -> 广播式
        amqpAdmin.declareExchange(new FanoutExchange("amqpfanout.exchange",true,false));

        // 创建两个 Queue
        amqpAdmin.declareQueue(new Queue("amqpfanout.queue1",true));
        amqpAdmin.declareQueue(new Queue("amqpfanout.queue2",true));

        // 创建绑定关系
        amqpAdmin.declareBinding(new Binding("amqpfanout.queue1", Binding.DestinationType.QUEUE,
                "amqpfanout.exchange","amqp.test1",null));
        amqpAdmin.declareBinding(new Binding("amqpfanout.queue2", Binding.DestinationType.QUEUE,
                "amqpfanout.exchange","amqp.test2",null));

        System.out.println("========== 创建成功 ==========");

    }



}




















