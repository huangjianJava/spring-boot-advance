package com.huangj.advance.javabase.seventeenchapter;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/12/10
 */
public class GenericClass2<S, D> {

    private S oneAttr;

    private D twoAttr;

    public GenericClass2() {
    }

    public GenericClass2(S oneAttr, D twoAttr) {
        this.oneAttr = oneAttr;
        this.twoAttr = twoAttr;
    }

    public S getOneAttr() {
        return oneAttr;
    }

    public void setOneAttr(S oneAttr) {
        this.oneAttr = oneAttr;
    }

    public D getTwoAttr() {
        return twoAttr;
    }

    public void setTwoAttr(D twoAttr) {
        this.twoAttr = twoAttr;
    }
}
