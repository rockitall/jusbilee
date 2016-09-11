package com.jusbilee.app.utils;

import java.util.Date;

/**
 * Created by Allen on 2016/9/11.
 */
public class OnlineUtils {
    public static int onlineStatus(Date startTime, Date endTime) {
        long now = System.currentTimeMillis();
        if (startTime != null && startTime.getTime() > now) {
            return 1;
        }
        if (endTime != null && endTime.getTime() < now) {
            return -1;
        }
        return 0;
    }
}
