package com.jusbilee.app.qiniu;

/**
 * @author zhandc 2016年8月27日
 */
public class QiniuSDKProperties {
    private String accessKey;
    private String secretKey;

    private QiniuBucket image;
    private QiniuBucket music;
    private QiniuBucket avatar;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public QiniuBucket getImage() {
        return image;
    }

    public void setImage(QiniuBucket image) {
        this.image = image;
    }

    public QiniuBucket getMusic() {
        return music;
    }

    public void setMusic(QiniuBucket music) {
        this.music = music;
    }

    public QiniuBucket getAvatar() {
        return avatar;
    }

    public void setAvatar(QiniuBucket avatar) {
        this.avatar = avatar;
    }
}
