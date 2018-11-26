package com.huangj.advance.javabase;

import org.junit.Test;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/18
 */
public class JavaBaseTest {

    @Test
    public void test7() {
        TestTwo testTwo = new TestTwo();


        TestOne one = new TestOne();
        one.name = "小米";
        one.address = "地址";
        System.out.println(one.name + "," + one.address);
    }

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

        System.out.println("测试一下");
        List<Integer> intList = Arrays.asList(1, 5, 2);
        //List<Integer> sortedList = intList.stream().sorted().collect(Collectors.toList());
        Collections.sort(intList);
        intList.forEach(System.out::println);
    }

    @Test
    public void test6() {
        int[][] arr4 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("原二维数组：");
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) { //遍历一维数组
                System.out.print("\t" + arr4[i][j]);
            }
            System.out.println();
        }
        System.out.println("互调后的二维数组：");
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print("\t" + arr4[j][i]);
            }
            System.out.println();
        }

        // java.util 排序
        int[] arr3 = {6, 3, 8, 2, 9, 1};
        Arrays.sort(arr3);
        System.out.println("java.util排序后的数组:");
        for (int i : arr3) {
            System.out.println(i);
        }

        // 直接选择排序
        System.out.println("=========== 直接选择排序 ============");
        int[] arr2 = {6, 3, 8, 2, 9, 1};
        int tempIndex;
        for (int i = 1; i < arr2.length; i++) {
            tempIndex = 0;
            // for 循环找出最大值的下标
            for (int j = 1; j < arr2.length - i; j++) {
                if (arr2[j] > arr2[tempIndex]) {
                    tempIndex = j;
                }
            }
            // 将最大值和第一位交换位置(拿出去)
            int tempArr = arr2[arr2.length - i];
            arr2[arr2.length - i] = arr2[tempIndex];
            arr2[tempIndex] = tempArr;
        }
        System.out.println("直接选择排序后的数组:");
        for (int i : arr2) {
            System.out.println(i);
        }

        // 冒泡排序
        System.out.println("=========== 冒泡排序 ============");
        int[] arr = {6, 3, 8, 2, 9, 1};

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        boolean sort = ArrayUtils.isSorted(arr);
        System.out.println("sort:" + sort);
        System.out.println("冒泡排序后的数组:");
        for (int i : arr) {
            System.out.println(i);
        }
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
