package com.huangj.advance.javabase.seventeenchapter;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/12/10
 */
public class GenericClassSon extends GenericClass<Integer> {

    private String sonName;

    public GenericClassSon(String sonName) {
        this.sonName = sonName;
    }

    public GenericClassSon(Integer testAttribute, String sonName) {
        super(testAttribute);
        this.sonName = sonName;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }
}
