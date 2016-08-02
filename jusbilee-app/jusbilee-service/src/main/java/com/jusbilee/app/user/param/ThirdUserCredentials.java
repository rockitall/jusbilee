package com.jusbilee.app.user.param;

public class ThirdUserCredentials {
    private ThirdUserType userType;
    private String accessToken;
    private String openid;

    public ThirdUserType getUserType() {
        return userType;
    }

    public String getUserTypeName() {
        return userType.name();
    }

    public void setUserType(ThirdUserType userType) {
        this.userType = userType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
