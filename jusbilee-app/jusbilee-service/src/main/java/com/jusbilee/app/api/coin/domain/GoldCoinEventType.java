package com.jusbilee.app.api.coin.domain;

/**
 * Created by Allen on 2016/9/10.
 */
public enum GoldCoinEventType {
    UNLOCK_PRACTICE_SONG(1, "练习歌曲解锁");

    private int eventId;
    private String eventName;

    private GoldCoinEventType(int eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }
}
