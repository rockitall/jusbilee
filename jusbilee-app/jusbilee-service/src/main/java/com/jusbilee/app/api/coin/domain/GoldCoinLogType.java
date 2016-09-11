package com.jusbilee.app.api.coin.domain;

/**
 * Created by Allen on 2016/9/10.
 */
public enum GoldCoinLogType {
    CONSUME((byte) -1, "支出"), PRODUCE((byte) 1, "收入");
    private byte value;
    private String name;

    private GoldCoinLogType(byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
