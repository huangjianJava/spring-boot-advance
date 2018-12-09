package com.huangj.advance.enums;

import java.util.function.Predicate;

/**
 * Created by huangj on 2017-08-30.
 * 逾期天数类型
 */
public enum UnAuditDaysType {
    INIT(-1, "默认值", (s) -> s == 0) {
        @Override
        public boolean satisfy(int intervalDays) {
            return predicate.test(intervalDays);
        }
    }, WITHIN_FIVE_AND_TEN_DAYS(0, "超过五天", (s) -> s >= 5 && s < 10) {
        @Override
        public boolean satisfy(int intervalDays) {
            return predicate.test(intervalDays);
        }
    }, OVER_TEN_DAYS(1, "超过十天", (s) -> s >= 10) {
        @Override
        public boolean satisfy(int intervalDays) {
            return predicate.test(intervalDays);
        }
    }, OVER_NINETY_DAYS(2, "超过九十天", (s) -> s > 90) {
        @Override
        public boolean satisfy(int intervalDays) {
            return predicate.test(intervalDays);
        }
    };

    int id;
    String desc;
    Predicate<Integer> predicate;

    public abstract boolean satisfy(int intervalDays);

    UnAuditDaysType(int id, String desc, Predicate<Integer> predicate) {
        this.id = id;
        this.desc = desc;
        this.predicate = predicate;
    }

    public int getId() {
        return this.id;
    }

    public String getDesc() {
        return this.desc;
    }

    public Predicate<Integer> getPredicate() {
        return predicate;
    }

}
