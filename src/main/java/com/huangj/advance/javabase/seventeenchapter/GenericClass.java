package com.huangj.advance.javabase.seventeenchapter;

/**
 * @author huangj
 * @version V1.0
 * @title:  泛型类
 * @description:
 * @date 2018/12/10
 */
public class GenericClass<T> {

    private T testAttribute;

    private String name;

    public GenericClass(T testAttribute) {
        this.testAttribute = testAttribute;
    }

    public GenericClass() {
    }

    public GenericClass(T testAttribute, String name) {
        this.testAttribute = testAttribute;
        this.name = name;
    }

    public T getTestAttribute() {
        return testAttribute;
    }

    public void setTestAttribute(T testAttribute) {
        this.testAttribute = testAttribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
