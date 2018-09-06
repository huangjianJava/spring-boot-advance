package com.huangj.advance.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: huangj
 * Description:
 * Date: 2018/9/6
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    public String name;

    private int age;

    public void methodOne(){
        System.out.println("无参无返回值方法");
    }

    public String methodTwo(String beer){
        System.out.println("有参有返回值,beer:" + beer);
        return beer;
    }



}
