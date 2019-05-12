package com.huangj.advance.utils;

/**
 * @author huangj
 * @title:
 * @description:
 * @date 2019/4/16
 */
public class NULL {

    public static void haha() {
        System.out.println("haha");
    }

    public static void test(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }


    Thread th1 = new Thread(() -> {
        synchronized (this) {
            for (int i = 1; i < 53; i++) {
                System.out.println(i);
                if (i % 2 == 0) { // 判读i是否等于0，
                    try {
                        this.notify();// 唤起下个线程
                        this.wait();// 等于0让该线程停止
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });

    // 打印字母的线程
    Thread th2 = new Thread(() -> {
        synchronized (this) {
            for (int i = 0; i < 26; i++) {
                System.out.println((char) +(65 + i));
                this.notify();// 唤起其他线程
                try {
                    Thread.sleep(1000);
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    });


    public static void main(String[] args) {

        System.out.println((char)(65 + 2));

       /* NULL test = new NULL();

        Thread th1 = new Thread();
        Thread th2 = new Thread();

        test.th1.start();
        test.th2.start();*/

        /*Integer a = new Integer(9);
        Long b = new Long(9);
        boolean test = a.equals(b);
        System.out.println(test);*/

       /* StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");

        test(a,b);

        System.out.println(a + "," + b);*/

        /*int sum = 0;
        for (int i = 1; i < 100; i++)
            sum += 1 / i;
        System.out.println(sum);*/



        /*String s;
        System.out.println("s=" + s);*/

       /* Thread thread = new Thread();
        thread.getPriority()

        ((NULL)null).haha();*/
    }

}
