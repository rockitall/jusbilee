package com.jusbilee.app.user.param;

public class ThirdUserCredentials {
    private ThirdUserType userType;
    private String userId;
    private String accessToken;
    private String nickname;

    public ThirdUserType getUserType() {
        return userType;
    }

    public String getUserTypeName() {
        return userType.name();
    }

    public void setUserType(ThirdUserType userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
