package com.jusbilee.app.module.user.account.service;

import com.jusbilee.app.module.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.module.user.account.domain.ThirdUserBase;

/**
 * Created by Allen on 2016/8/1.
 */
public interface ThirdUserLookup {
    ThirdUserBase lookup(ThirdUserCredentials credentials);
}
