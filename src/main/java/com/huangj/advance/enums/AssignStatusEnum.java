package com.huangj.advance.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangj
 * @Description: 认领状态
 * @date 2018/10/19
 */
public enum AssignStatusEnum {
    NO_APPLY(1, "未被申领"), HAVE_APPLY(2, "已被申领"), HAVE_ASSIGN(3, "已被认领");

    AssignStatusEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static AssignStatusEnum parse(int value) {
        for (AssignStatusEnum type : values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        return null;
    }

    public static boolean isContain(int value) {
        return getEnumAllValues().contains(value);
    }

    public static List<Integer> getEnumAllValues() {
        return Arrays.stream(values())
                .map(e -> e.getValue())
                .collect(Collectors.toList());
    }

    private int value;

    private String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
