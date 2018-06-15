package com.huangj.advance;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling			// 开启定时任务
@EnableRabbit  				// 开启基于注解的RabbitMQ模式
@SpringBootApplication
public class AdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceApplication.class, args);
	}
}
