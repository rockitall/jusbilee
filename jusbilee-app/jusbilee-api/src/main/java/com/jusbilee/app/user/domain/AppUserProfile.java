package com.jusbilee.app.user.domain;

import com.jusbilee.app.user.account.domain.AppUser;

/**
 * Created by Allen on 2016/8/22.
 */
public class AppUserProfile {
    private AppUser appUser;

    public AppUserProfile(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getNickname() {
        return this.appUser.getNickname();
    }

    public String getAvatar() {
        return appUser.getAvatar();
    }
}
