package com.jusbilee.app.api.user.account.service;

import com.jusbilee.app.api.user.account.domain.ThirdUserBase;
import com.jusbilee.app.api.user.account.param.ThirdUserCredentials;

/**
 * Created by Allen on 2016/8/1.
 */
public interface ThirdUserLookupService {
    ThirdUserBase lookup(ThirdUserCredentials credentials);
}
