package com.huangj.advance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huangj
 * @Description:    测试读取配置文件映射到该组件上
 * @date 2018/5/28
 */

@Component  // 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能
@ConfigurationProperties(prefix = "test") // 指定配置文件中需要映射的属性
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonConfig {

    private String account;

    private String password;

}
