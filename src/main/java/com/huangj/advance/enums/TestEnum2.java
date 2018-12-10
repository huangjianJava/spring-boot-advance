package com.huangj.advance.enums;

/**
 * @author huangj
 * @version V1.0
 * @title:
 * @description:
 * @date 2018/12/10
 */
public enum TestEnum2 {

    CON_1(1) {
        @Override
        public boolean satisfy() {
            return false;
        }

        @Override
        public String display() {
            return "我是CON_1";
        }
    }, CON_2(2) {
        @Override
        public String display() {
            return "我是CON_2";
        }
    }, CON_3(3, "CON_3") {
        @Override
        public String display() {
            return "我是CON_3";
        }
    };

    private int value;

    private String desc;

    TestEnum2(int value) {
        this.value = value;
    }

    TestEnum2(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public boolean satisfy() {
        return true;
    }

    public abstract String display();

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
