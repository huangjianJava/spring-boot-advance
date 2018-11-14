package com.huangj.advance.designmode.model1;

/**
 * Author: huangj
 * Description:
 * Date: 2018/11/14
 */
public class FirstFly implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("第一个飞翔行为。");
    }
}
