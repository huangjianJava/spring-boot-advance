package com.huangj.advance.designmode;

import lombok.*;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/11/14
 */
@Getter
@Setter
public class TwoDuck extends Duck {

    @Override
    public void display() {
        System.out.println("TwoDuck.我叫" + super.getName());
    }
}
