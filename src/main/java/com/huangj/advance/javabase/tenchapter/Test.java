package com.huangj.advance.javabase.tenchapter;

import com.huangj.advance.common.exception.ServiceException;

import java.io.File;

/**
 * @author huangj
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2018/10/22
 */
public class Test {

    public static void testException() {
        File file = new File("D://a.txt");
        String path = file.getAbsolutePath();
        System.out.println(path);
    }

    public static String testException(int messageCode) {
        try {
            if (messageCode > 10) {
                throw new ServiceException("messageCode 大于10");
            }
        } catch (ServiceException ex) {
            System.out.println("执行catch");
            return "执行catch-return";
        } finally {
            System.out.println("执行finally");
            return "执行finally-return";
        }
        //return "执行finally后面的return:" + messageCode;
    }

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
        String message = testException(11);
        System.out.println("运行结果:" + message);

        /*String message = Test.testException(11);
        System.out.println(message);*/

       /* Son1 son1 = new Son1();
        son1.finalMethod();*/

        //Test.sayTest(new Son2());
        /*int length = Test.add(1,2,3);
        System.out.println(length);*/
    }

}
