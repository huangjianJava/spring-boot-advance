package com.huangj.advance.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author huangj
 * @Description:  登录 controller
 * @date 2018/5/31
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String DEFAULT_PASSWORD = "123456";

    @PostMapping(value = "/normal",produces = MediaType.APPLICATION_JSON_VALUE)
    public String LoginByNormal(@RequestParam String username, @RequestParam String password,
                                ModelMap map, HttpSession session){
        // 登录失败
        if(StringUtils.isBlank(username) || !StringUtils.equals(DEFAULT_PASSWORD,password)){
            map.addAttribute("login_error","账号或者密码错误");
            return "login";
        }

        // 登录成功
        session.setAttribute("username",username);
        return "redirect:/main.html";
    }

}



