package com.jusbilee.app.api.user.domain;

/**
 * Created by Allen on 2016/9/2.
 */
public class UploadToken {
    private String token;
    private String bucket;
    private String domain;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
