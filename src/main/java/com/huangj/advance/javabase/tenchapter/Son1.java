package com.huangj.advance.javabase.tenchapter;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/26
 */
public class Son1 extends Parent {

    @Override
    public void say() {
        System.out.println("son1");
    }

    public void display(String address){
        System.out.println("地址：" + address);
    }

}
