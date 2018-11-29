package com.huangj.advance.javabase.tenchapter;

/**
 * @author huangj
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2018/10/22
 */
public class Test {

    public static String add(String a, int b) {
        return "1";
    }

    public static String add(int b, String a) {
        return "1";
    }

    public static int add(String a, int b, String c) {
        return 1;
    }

    public static int add(int... a) {
        return a.length;
    }

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
        /*int length = Test.add(1,2,3);
        System.out.println(length);*/
    }

}
