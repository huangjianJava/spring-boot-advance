package com.huangj.advance.javabase;

import lombok.NoArgsConstructor;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/18
 */
@NoArgsConstructor
public class One {

    public static String ERROR = "错误信息";

    private final String TEST = "测试一下";

    public static final String MYSELF = "自己";

    public void outTest(){
        System.out.println("ERROR:" + ERROR);
    }

    public static void staticTest(){
        System.out.println("static 方法测试");
    }

}
