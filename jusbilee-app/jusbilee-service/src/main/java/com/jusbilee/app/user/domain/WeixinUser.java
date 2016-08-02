package com.jusbilee.app.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeixinUser extends ThirdUserBase {
    private Integer sex;
    private String province;
    private String city;
    private String country;

    @JsonProperty("openid")
    public void setOpenid(String openid) {
        super.openid = openid;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        super.nickname = nickname;
    }

    @JsonProperty("headimgurl")
    public void setAvatar(String avatar) {
        super.avatar = avatar;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
