package com.huangj.advance.javabase.seven;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/11/23
 */
public class StaticPerson {

    static {
        System.out.println("静态代码块");
        age = 21;
    }

    {
        System.out.println("非静态代码块");
    }

    public String name;

    public final static String address = "衡阳";

    static int age;

    public StaticPerson() {
        System.out.println("无参构造");
    }

    public StaticPerson(String name) {
        this.name = name;
        System.out.println("全参构造");
    }

    public static void main(String[] args) {
        System.out.println("main args length:" + args.length);

        int one2 = StaticPerson.age;
        System.out.println("one2:" + one2);

        /*StaticPerson staticPerson = new StaticPerson();
        int one = staticPerson.age;
        System.out.println("one:" + one);*/
    }

}
