package com.huangj.advance.javabase.tenchapter;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/26
 */
public class Test {

    public static void sayTest(Parent p){
        if(p instanceof Son1){
            System.out.println("son1 测试");
            p.say();
        }

        if(p instanceof Son2){
            System.out.println("son2 测试");
            p.say();
        }
    }

    public static void main(String[] args) {
        Test.sayTest(new Son2());
    }

}
