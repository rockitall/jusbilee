package com.jusbilee.app.api.practice.request;

import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/9/10.
 */
public class PracticeSongUnlockRequest {
    @NotNull(message = "songId不能为空")
    private Integer songId;

}
