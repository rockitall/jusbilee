package com.jusbilee.app.api.user.account.domain;

/**
 * Created by Allen on 2016/8/22.
 */
public class MyProfile extends AppUserProfile {
    private int upgradePoints;

    public int getUpgradePoints() {
        return upgradePoints;
    }

    public void setUpgradePoints(int upgradePoints) {
        this.upgradePoints = upgradePoints;
    }
}
