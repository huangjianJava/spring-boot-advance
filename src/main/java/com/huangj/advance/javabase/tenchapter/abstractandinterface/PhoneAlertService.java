package com.huangj.advance.javabase.tenchapter.abstractandinterface;

/**
 * @author huangj
 * @title: 电话报警类
 * @description: 继承了报警的抽象类
 * @date 2018/11/28
 */
public class PhoneAlertService extends AbstractAlertService {

    @Override
    public String getAlertType() {
        return "电话报警方式";
    }

    @Override
    public void execute() {
        System.out.println("电话报警方式主要是通过拨打110的方式进行报警");
    }

}
