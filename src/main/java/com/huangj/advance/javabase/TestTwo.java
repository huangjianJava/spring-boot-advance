package com.huangj.advance.javabase;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/22
 */
public class TestTwo {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestTwo() {
    }

    public TestTwo(int age) {
        this.age = age;
    }

    public TestTwo(int age, String name) {
        this(age);
        this.name = name;
    }

    public String say(){
        return this.age + "," + this.name;
    }
}
