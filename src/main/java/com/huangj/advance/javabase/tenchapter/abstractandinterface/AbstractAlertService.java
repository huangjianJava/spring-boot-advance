package com.huangj.advance.javabase.tenchapter.abstractandinterface;

/**
 * @author huangj
 * @title: 报警的抽象类
 * @description:
 * @date 2018/11/28
 */
public abstract class AbstractAlertService {

    /**
     * 每个报警的方式都需要报警，所以在父类中定义普通的成员
     * 变量让子类继承调用，在该方法中可以进行报警的逻辑编写，
     * 将不同的报警方式这些变动的东西，定义为抽象方法，让其
     * 子类具体的去实现
     */
    public void alert() {
        System.out.println("执行报警");
        String alertType = getAlertType();
        System.out.println("报警方式:" + alertType);
        execute();
    }

    /**
     * 报警的方式，是微信还是邮件等等不同的子类方式
     *
     * @return
     */
    public abstract String getAlertType();

    /**
     * 具体的每种报警方式的实现
     */
    public abstract void execute();

}
