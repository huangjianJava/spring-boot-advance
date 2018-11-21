package com.huangj.advance.javabase;

import org.junit.Test;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/18
 */
public class JavaBaseTest {

    @Test
    public void test11() {
        int[] test = new int[3];
        Arrays.fill(test, 5);
        for (int t : test) {
            System.out.println(t);
        }

        int search = Arrays.binarySearch(test, 5);
        System.out.println("search:" + search);

        // ArrayUtils
        boolean isContain = ArrayUtils.contains(test, 5);
        System.out.println("isContain:" + isContain);

        int[] intArr = ArrayUtils.EMPTY_INT_ARRAY;
        System.out.println(intArr);
    }


    @Test
    public void test2() {
        List<String> list = Arrays.asList("1", "2", "a");
        String str1 = StringUtils.join(list);
        System.out.println("str1:" + str1);

        String[] arr = new String[3];
        arr[0] = "3";
        arr[1] = "4";
        arr[2] = "5";
        String str2 = StringUtils.join(arr);
        System.out.println("str2:" + str2);
    }

    @Test
    public void testRegex() {
        String regex = "^[a-z]{3,7}$";
        String phone1 = "1231";
        String phone2 = "abcd";

        boolean match1 = phone1.matches(regex);
        boolean match2 = phone2.matches(regex);
        System.out.println("match1:" + match1);
        System.out.println("match2:" + match2);
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
        /*String regex = "1[34578]\\d{9}";
        String phone1 = "1231";
        String phone2 = "15773002366";

        boolean match1 = phone1.matches(regex);
        boolean match2 = phone2.matches(regex);
        System.out.println("match1:" + match1);
        System.out.println("match2:" + match2);*/

        // ^[a-z0-9A-Z]+[-|a-z0-9A-Z._]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$
        String regex2 = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";
        String email1 = "597112336@qq.com";
        String email2 = "123@163.com";

        boolean match3 = email1.matches(regex2);
        boolean match4 = email2.matches(regex2);
        System.out.println("match3:" + match3);
        System.out.println("match4:" + match4);
    }

}
