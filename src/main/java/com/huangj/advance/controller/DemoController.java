package com.huangj.advance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangj
 * @Description:  demo controller
 * @date 2018/5/25
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello world";
    }

}


















