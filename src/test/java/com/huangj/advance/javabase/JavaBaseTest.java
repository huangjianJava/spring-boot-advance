package com.huangj.advance.javabase;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.huangj.advance.dto.TestDto;
import com.huangj.advance.enums.ConstantInterface;
import com.huangj.advance.enums.TestEnum;
import com.huangj.advance.enums.TestEnum2;
import com.huangj.advance.javabase.seven.StaticPerson;
import com.huangj.advance.javabase.seventeenchapter.*;
import com.huangj.advance.javabase.sixteenchapter.AnnotationTest;
import com.huangj.advance.javabase.sixteenchapter.MethodAnnotation;
import com.huangj.advance.javabase.tenchapter.abstractandinterface.EmailAlertService;
import com.huangj.advance.javabase.tenchapter.abstractandinterface.PhoneAlertService;
import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.math.BigInteger;

import com.huangj.advance.javabase.tenchapter.Parent;
import com.huangj.advance.javabase.tenchapter.Son1;
import org.apache.commons.lang3.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/18
 */
public class JavaBaseTest {

    @Test
    public void test172() {
        /*GenericClass one = new GenericClass("第一个","小明");
        System.out.println("one:" + one.getTestAttribute());
        GenericClass two = new GenericClass(11,"小明");
        System.out.println("two:" + two.getTestAttribute());
        GenericClass<String> three = new GenericClass<>("第三个","小花");*/

        /*GenericClass2 one = new GenericClass2("第一个",1);
        GenericClass2<String,String> two = new GenericClass2<>("1","2");*/
        //GenericClassSon<String> one = new GenericClassSon<>("1","2");

        /*InterfaceClass one = new InterfaceClass();
        String result = one.display("测试一下");
        System.out.println("result:" + result);*/

        /*InterfaceClass2<Integer> one = new InterfaceClass2<>();
        int result = one.display(123);
        System.out.println(result);*/

        /*List<Number> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }*/

        /*GenericClass<String> one = new GenericClass<>("测试");
        GenericClass<Integer> two = new GenericClass<>(1);
        TestUtil.show(one);
        TestUtil.show(two);*/
       /* GenericClass<String> one = new GenericClass<>("测试");
        GenericClass<Integer> two = new GenericClass<>(1);
        TestUtil.show2(one);
        TestUtil.show2(two);*/

        //String one = TestUtil.say("1t","3t","2t");
        //System.out.println(one);
        List<?>[] ls = new ArrayList<?>[10];

    }

    @Test
    public void test171() {
        int constantA = ConstantInterface.CONSTANT_A;
        String name = TestEnum.CONSTANT_A.name();
        TestEnum b = TestEnum.CONSTANT_B;
        TestEnum b1 = TestEnum.CONSTANT_B;

        boolean one = TestEnum2.CON_1.satisfy();
        boolean two = TestEnum2.CON_2.satisfy();

        String oneStr = TestEnum2.CON_1.display();
        String twoStr = TestEnum2.CON_2.display();

    }

    @Test
    public void test152() {
        // FileUtils
        // IOUtils
        // FilenameUtils
    }

    @Test
    public void test161() {
        AnnotationTest anno = new AnnotationTest();
        Class classTest = anno.getClass();

        // 获取类中所有的方法
        Method[] methods = classTest.getDeclaredMethods();
        for (Method method : methods) {
            // 判断方法是否有被指定注解注释
            if (method.isAnnotationPresent(MethodAnnotation.class)) {
                String name = method.getName();
                MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
                String displayDes = methodAnnotation.display();
                System.out.println("方法名:" + name + ",注解注释的信息:" + displayDes);
            }
        }
    }

    @Test
    public void test151() {
        //当前日期
        Date date = new Date();
        //格式化并转换String类型
        String dir = DateFormatUtils.format(date, "yyyy/MM/dd");
        String path = "D:/" + dir;
        System.out.println("path:" + path);

        //创建文件夹
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("创建目录");
            f.mkdirs();
        } else {
            System.out.println("目录已经存在");
        }
    }

    @Test
    public void test147() {
        ListMultimap<String, String> myMultimap = ArrayListMultimap.create();

        // Adding some key/value  ListMultimap
        myMultimap.put("test", "myTest");
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        Map<String, Collection<String>> newMap = myMultimap.asMap();
        List<String> valueList = myMultimap.get("Fruits");
        valueList.forEach(e -> System.out.println(e));
    }

    @Test
    public void test146() {
        Map<Integer, List<String>> map = new HashMap();
        map.put(1, Arrays.asList("a", "b"));
        map.put(1, Arrays.asList("a", "b"));
        List<String> list = map.get(1);
    }

    @Test
    public void test145() {
        Map<Integer, String> map = new HashMap();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");

        System.out.println("===iterator 循环方式");
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String value = map.get(iterator.next());
            System.out.println(value);
        }

        System.out.println("===for 循环方式");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-" + value);
        }
    }

    @Test
    public void test144() {
        String[] strArray = new String[]{"a", "b", "c", "a"};
        List<String> list = Arrays.asList(strArray);
        /*System.out.println("list size:" + list.size());
        list.add("test");*/
        System.out.println(list.size());
        /*Set<String> set = new HashSet<>(list);
        System.out.println("set size:" + set.size());
        set.add("test");
        System.out.println("final set size:" + set.size());*/
        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println("final set size:" + set.size());

        /*TestDto one = TestDto.builder()
                .name("小明")
                .totalSales(11L)
                .build();
        TestDto two = TestDto.builder()
                .name("小明")
                .totalSales(11L)
                .build();
        List<TestDto> list1 = new ArrayList<>();
        list1.add(one);
        list1.add(two);
        Set<TestDto> set1 = new HashSet<>(list1);*/

    }

    @Test
    public void test143() {
        /*TestDto one = TestDto.builder()
                .name("小明")
                .totalSales(11L)
                .build();
        TestDto two = TestDto.builder()
                .name("小米")
                .totalSales(121L)
                .build();*/
        /*Set<TestDto> hashSet = new HashSet<>();
        hashSet.add(one);
        hashSet.add(two);
        for(TestDto dto : hashSet){
            System.out.println(dto.getName());
        }*/

        /*Set<TestDto> treeSet = new TreeSet<>();
        treeSet.add(one);
        treeSet.add(two);
        for (TestDto dto : treeSet) {
            System.out.println(dto.getName());
        }*/

    }

    @Test
    public void test142() {
        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            intSet.add(i);
        }

        System.out.println("=== Iterator 循环");
        Iterator<Integer> iterator = intSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("=== foreach 循环输出");
        for (Integer i : intSet) {
            System.out.println(i);
        }
    }

    @Test
    public void test141() {
        List<Integer> intList = new ArrayList<>();
        intList.add(null);
        intList.add(2);
        intList.add(1);
        intList.add(3);
        // 循环List
        System.out.println("=== iterator 循环输出");
        Iterator iterator = intList.iterator();
        while (iterator.hasNext()) {
            int tempInt = (Integer) iterator.next();
            System.out.println(tempInt);
        }

        System.out.println("=== foreach 循环输出");
        for (Integer i : intList) {
            System.out.println(i);
        }

        System.out.println("=== for 循环输出");
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
    }

    @Test
    public void test101() {
        EmailAlertService emailAlertService = new EmailAlertService();
        emailAlertService.alert();
        System.out.println("===== 分割线 =====");
        PhoneAlertService phoneAlertService = new PhoneAlertService();
        phoneAlertService.alert();
    }

    @Test
    public void test12() {
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
    public void test10() {
        Parent p = new Parent();
        boolean one = p instanceof Son1;
        System.out.println("one:" + one);

        Son1 son1 = new Son1();
        boolean two = son1 instanceof Parent;
        System.out.println("two:" + two);

    }

    @Test
    public void test9() {
        int randomInt = RandomUtils.nextInt(2, 32);
        System.out.println("randomInt:" + randomInt);
    }

    @Test
    public void test8() {
        Boolean test = Boolean.valueOf("false");
        System.out.println(test);

        BigInteger one = BigInteger.ONE;
        BigInteger two = one.and(BigInteger.ZERO);
    }

    @Test
    public void test7() {
        StaticPerson one = new StaticPerson();
        String test = one.address;
        String staticAddr = StaticPerson.address;
        TestTwo testTwo = new TestTwo();
        /*TestOne one = new TestOne();
        one.name = "小米";
        one.address = "地址";
        System.out.println(one.name + "," + one.address);*/
    }

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
    public void myTest() {
        String one = new String("hello");
        String two = "hello";

        boolean equalsOne = one == two;
        boolean equalsTwo = one.equals(two);
        System.out.println(equalsOne + "----" + equalsTwo);
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
