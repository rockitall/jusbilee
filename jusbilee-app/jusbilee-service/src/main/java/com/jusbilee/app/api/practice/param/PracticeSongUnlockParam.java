package com.jusbilee.app.api.practice.param;

import com.jusbilee.app.api.practice.domain.UnlockType;

/**
 * Created by Allen on 2016/9/10.
 */
public class PracticeSongUnlockParam {
    private UnlockType unlockType;
    private Integer songId;
    private Long userId;

    public UnlockType getUnlockType() {
        return unlockType;
    }

    public void setUnlockType(UnlockType unlockType) {
        this.unlockType = unlockType;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
