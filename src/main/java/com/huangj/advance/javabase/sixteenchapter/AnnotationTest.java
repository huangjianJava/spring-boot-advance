package com.huangj.advance.javabase.sixteenchapter;

import lombok.Data;

/**
 * @author huangj
 * @title:
 * @description:
 * @date 2018/12/5
 */
@Data
public class AnnotationTest {

    private String name;

    public String show(){
        return "我是show方法";
    }

    @MethodAnnotation(display = "调用say()方法")
    public void say() {
        System.out.println("我是AnnotationTest类");
    }

}
