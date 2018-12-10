package com.huangj.advance.javabase.seventeenchapter;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/12/10
 */
public class TestUtil {

    public static void show2(GenericClass<?> one) {
        System.out.println(one.getTestAttribute());
    }

    public static <T> T say(T... one){
        return one[one.length/2];
    }

    public static void show(GenericClass<String> one) {
        System.out.println(one.getTestAttribute());
    }

}
