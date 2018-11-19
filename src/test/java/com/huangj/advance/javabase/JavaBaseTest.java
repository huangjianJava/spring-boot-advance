package com.huangj.advance.javabase;

import org.junit.Test;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/18
 */
public class JavaBaseTest {

    @Test
    public void test1() {
        String oneStr = "第一个";
        String twoStr = "第一个";
        boolean equalsTrue = oneStr == twoStr;
        boolean equalsTrue2 = oneStr.equals(twoStr);
        System.out.println("equalsTrue:" + equalsTrue);
        System.out.println("equalsTrue2:" + equalsTrue2);

        String str1 = new String("测试一");
        String str2 = new String("测试一");
        boolean testFlag = str1.equals(str2);
        boolean testFlag2 = str1 == str2;
        System.out.println("testFlag:" + testFlag);
        System.out.println("testFlag2:" + testFlag2);

        String s3 = new String("hello");
        String s4 = "hello";
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

    }

}
