package com.jusbilee.app.api.practice.domain;

/**
 * Created by Allen on 2016/9/10.
 */
public enum UnlockType {
    NO_NEED_UNLOCK(0, "无需解锁"), PASS_STAGE(1, "闯关解锁"), GOLD_COIN(2, "金币解锁");
    private int value;
    private String name;

    UnlockType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }
}
