package com.huangj.advance.javabase;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/18
 */
public class JavaBaseTest {

    @Test
    public void test6() {
       /* Integer test = 1 & 0;
        Integer test21 = 1 | 0;*/
        int test = 0;
        List<Integer> list = Arrays.asList(0, 0, 1);
        for (int i = 0; i < list.size(); i++) {
            test = test | list.get(i);
        }
        System.out.println("test:" + test);




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
