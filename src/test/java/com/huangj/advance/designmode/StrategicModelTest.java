package com.huangj.advance.designmode;

import com.huangj.advance.designmode.model1.OneDuck;
import com.huangj.advance.designmode.model1.SecondFly;
import com.huangj.advance.designmode.model1.TwoDuck;
import org.junit.Test;

/**
 * @author huangj
 * @version V1.0
 * @title: 策略模式测试
 * @description:
 * @date 2018/11/14
 */
public class StrategicModelTest {

    @Test
    public void test2() {
        OneDuck oneDuck = new OneDuck();
        oneDuck.setFlyBehavior(new SecondFly());
        oneDuck.display();
        oneDuck.getFlyBehavior().fly();
    }

    @Test
    public void test1() {
        OneDuck oneDuck = new OneDuck();
        oneDuck.display();

        TwoDuck twoDuck = new TwoDuck();
        twoDuck.display();
    }

}

























