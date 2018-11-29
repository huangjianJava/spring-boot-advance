package com.huangj.advance.javabase.tenchapter;

/**
 * @author huangj
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2018/10/22
 */
public class Test {

    public static void sayTest(Parent p) {
        if (p instanceof Son1) {
            System.out.println("son1 测试");
            p.say();
        }

        if (p instanceof Son2) {
            System.out.println("son2 测试");
            p.say();
        }
    }

    public static void main(String[] args) {
        Test.sayTest(new Son2());
    }

}
