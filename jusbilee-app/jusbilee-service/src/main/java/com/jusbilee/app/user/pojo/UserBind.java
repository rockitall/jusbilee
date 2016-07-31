package com.jusbilee.app.user.pojo;

public class UserBind {
    private Long id;
    private Long userId;
    private String thirdUserType;
    private String thirdUserIdentify;
    private Byte thirdLoginType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getThirdUserType() {
        return thirdUserType;
    }

    public void setThirdUserType(String thirdUserType) {
        this.thirdUserType = thirdUserType;
    }

    public String getThirdUserIdentify() {
        return thirdUserIdentify;
    }

    public void setThirdUserIdentify(String thirdUserIdentify) {
        this.thirdUserIdentify = thirdUserIdentify;
    }

    public Byte getThirdLoginType() {
        return thirdLoginType;
    }

    public void setThirdLoginType(Byte thirdLoginType) {
        this.thirdLoginType = thirdLoginType;
    }
}