package com.huangj.advance.config;

import com.huangj.advance.component.LoginHandlerInterceptor;
import com.huangj.advance.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author huangj
 * @Description:  spring boot 扩展 spring mvc 的功能
 * @date 2018/5/30
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login.html","/login/normal","/we-chart/**");
    }

    // 注入自定义的区域解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
