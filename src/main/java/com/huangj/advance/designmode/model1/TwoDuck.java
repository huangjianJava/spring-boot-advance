package com.huangj.advance.designmode.model1;

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
@AllArgsConstructor
public class TwoDuck extends Duck {

    @Override
    public void display() {
        System.out.println("我叫 TwoDuck.");
    }
}
