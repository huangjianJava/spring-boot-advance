package com.huangj.advance.javabase;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/18
 */
public class JavaBaseTest {

    @Test
    public void test11() {
        int[] test = new int[3];
        Arrays.fill(test,5);
        for(int t : test){
            System.out.println(t);
        }

        int search = Arrays.binarySearch(test,5);
        System.out.println("search:" + search);

        // ArrayUtils
        boolean isContain = ArrayUtils.contains(test,5);
        System.out.println("isContain:" + isContain);

        int[] intArr = ArrayUtils.EMPTY_INT_ARRAY;
        System.out.println(intArr);


    }

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
