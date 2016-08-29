package com.jusbilee.app.api.user.account.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SinaWeiboUser extends ThirdUserBase {
    private String province;
    private String city;
    private String location;
    private String gender;

    @JsonProperty("id")
    public void setOpenid(String openid) {
        super.openid = openid;
    }

    @JsonProperty("name")
    public void setNickname(String nickname) {
        super.nickname = nickname;
    }

    @JsonProperty("profile_image_url")
    public void setAvatar(String avatar) {
        super.avatar = avatar;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
