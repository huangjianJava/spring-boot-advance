package com.huangj.advance.javabase.tenchapter.abstractandinterface;

/**
 * @author huangj
 * @title: 邮件报警类
 * @description: 继承了报警的抽象类
 * @date 2018/11/28
 */
public class EmailAlertService extends AbstractAlertService {

    @Override
    public String getAlertType() {
        return "邮件报警方式";
    }

    @Override
    public void execute() {
        System.out.println("邮件报警方式具体是通过发送邮件的形式去报警");
    }

}
