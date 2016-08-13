package com.rockit.qcloud.im.common;


import com.jusbilee.app.common.utils.JacksonUtil;

/**
 * Created by Allen on 2016/8/13.
 */
public interface QCloudApiRequestBody {
    default String getAsString() {
        return JacksonUtil.toJson(this);
    }
}
