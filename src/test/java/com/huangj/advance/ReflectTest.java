package com.huangj.advance;

import com.huangj.advance.base.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author huangj
 * @Description:  java 基础测试类
 * @date 2018/5/29
 */
public class ReflectTest {

    @Test
    public void testSome() throws Exception {
        // 反射创建对象，获取属性，获取方法

        Class personClass = Person.class;

        Person p = (Person)personClass.newInstance();

        Field f1 = personClass.getField("name");
        f1.set(p,"小米");
        System.out.println(p);

        Field f2 = personClass.getDeclaredField("age");
        f2.setAccessible(true);
        f2.setInt(p,23);
        System.out.println(p);

        Method[] methods = personClass.getMethods();

        Method m1 = personClass.getMethod("methodOne");
        m1.invoke(p);

        Method m2 = personClass.getMethod("methodTwo",String.class);
        String outCome = (String) m2.invoke(p,"测试一下");
        System.out.println("结果:" + outCome);
    }

}

























