package com.huangj.advance.designmode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/11/14
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class Duck {

    private String name;

    /**
     * 每个鸭子都有自我介绍
     */
    public abstract void display();

}
