package com.jusbilee.app.admin.domain;

/**
 * Created by Allen on 2016/9/3.
 */
public interface Status {
    interface StageSongStatus {
        byte ONLINE = 0;
        byte DELETED = 1;
        byte OFFLINE = 2;
    }

    interface PracticeSongStatus {
        byte ONLINE = 0;
        byte DELETED = 1;
        byte OFFLINE = 2;
    }
}
