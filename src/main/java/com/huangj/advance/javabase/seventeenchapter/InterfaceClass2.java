package com.huangj.advance.javabase.seventeenchapter;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/12/10
 */
public class InterfaceClass2<T> implements GenericInterface<T> {

    @Override
    public T display(T params) {
        return params;
    }
}
