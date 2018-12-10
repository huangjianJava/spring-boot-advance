package com.huangj.advance.javabase.seventeenchapter;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/12/10
 */
public class InterfaceClass implements GenericInterface<String> {

    @Override
    public String display(String params) {
        return "String-" + params;
    }
}
