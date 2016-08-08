package com.rockit.signature;

/**
 * Created by Allen on 2016/8/8.
 */
public class UserSignatureProperties {
    private String sdkAppId;
    private String privateKeyFile;
    private String jniLibFile;
    private String expire = String.valueOf(30 * 24 * 60 * 60);

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getPrivateKeyFile() {
        return privateKeyFile;
    }

    public void setPrivateKeyFile(String privateKeyFile) {
        this.privateKeyFile = privateKeyFile;
    }

    public String getJniLibFile() {
        return jniLibFile;
    }

    public void setJniLibFile(String jniLibFile) {
        this.jniLibFile = jniLibFile;
    }

    public String getSdkAppId() {
        return sdkAppId;
    }

    public void setSdkAppId(String sdkAppId) {
        this.sdkAppId = sdkAppId;
    }

}
