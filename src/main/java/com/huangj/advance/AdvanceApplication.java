package com.huangj.advance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.huangj.advance.mapper")
@SpringBootApplication
public class AdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceApplication.class, args);
	}
}
