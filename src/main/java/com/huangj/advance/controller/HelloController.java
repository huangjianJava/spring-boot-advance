package com.huangj.advance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: huangj
 * Description:
 * Date: 2018/5/29
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
