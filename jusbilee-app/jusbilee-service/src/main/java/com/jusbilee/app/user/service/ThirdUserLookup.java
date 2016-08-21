package com.jusbilee.app.user.service;

import com.jusbilee.app.user.domain.ThirdUserBase;
import com.jusbilee.app.user.param.ThirdUserCredentials;

/**
 * Created by Allen on 2016/8/1.
 */
public interface ThirdUserLookup {
    ThirdUserBase lookup(ThirdUserCredentials credentials);
}
