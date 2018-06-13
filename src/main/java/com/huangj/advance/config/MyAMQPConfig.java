package com.huangj.advance.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangj
 * @Description:  Rabbit MQ 配置类
 * @date 2018/6/13
 */
@Configuration
public class MyAMQPConfig {

    /**
     * RabbitMq 默认采用的 java 的序列化器(byte 字节)，
     * 所以需要定义 Jackson2JsonMessageConverter 序列化(转化为JSON)
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
