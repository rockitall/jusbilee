package com.jusbilee.app.user.account.service;

import com.jusbilee.app.user.account.domain.ThirdUserBase;
import com.jusbilee.app.user.account.param.ThirdUserCredentials;

/**
 * Created by Allen on 2016/8/1.
 */
public interface ThirdUserLookup {
    ThirdUserBase lookup(ThirdUserCredentials credentials);
}
