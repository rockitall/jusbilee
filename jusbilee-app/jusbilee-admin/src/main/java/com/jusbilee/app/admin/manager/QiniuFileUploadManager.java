/**
 * zhandc 2016年8月26日
 */
package com.jusbilee.app.admin.manager;

import com.jusbilee.app.qiniu.QiniuBucket;
import com.jusbilee.app.qiniu.QiniuSDKProperties;
import com.jusbilee.app.qiniu.UploadFileNameUtils;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.rockit.core.exception.FileUploadException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhandc 2016年8月26日
 */

@Service
public class QiniuFileUploadManager {
    private static final Logger logger = LoggerFactory.getLogger(QiniuFileUploadManager.class);
    @Autowired
    private QiniuSDKProperties qiniuSDKProperties;

    private UploadManager uploadManager = new UploadManager();

    public String uploadImageFile(MultipartFile file, Auth auth, String imgType, String sn) {
        return upload(auth, file, qiniuSDKProperties.getImage(), imgType, sn);
    }

    public String uploadMusicFile(MultipartFile file, Auth auth, String musicType, String sn) {
        return upload(auth, file, qiniuSDKProperties.getMusic(), musicType, sn);
    }

    public String uploadAvatarFile(MultipartFile file, Auth auth, String sn) {
        return upload(auth, file, qiniuSDKProperties.getAvatar(), null, sn);
    }

    private String upload(Auth auth, MultipartFile file, QiniuBucket bucket, String type, String sn) throws FileUploadException {

        String filename = UploadFileNameUtils.getUploadFilename(file.getOriginalFilename(), bucket.getName(), type, sn);
        String token = auth.uploadToken(bucket.getName(), filename);
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("begin upload file:{}", filename);
            }
            uploadManager.put(file.getBytes(), filename, token);

            if (logger.isDebugEnabled()) {
                logger.debug("upload file:{} successfully", filename);
            }
        } catch (Exception e) {
            logger.error("upload file:{} error", filename, e);
            throw new FileUploadException();
        }
        return UploadFileNameUtils.getUploadUrl(bucket.getDomain(), filename);
    }

    public void deleteImageFile(Auth auth, String url) {
        deleteFile(auth, qiniuSDKProperties.getImage(), url);
    }

    public void deleteMusicFile(Auth auth, String url) {
        deleteFile(auth, qiniuSDKProperties.getMusic(), url);
    }

    public void deleteAvatarFile(Auth auth, String url) {
        deleteFile(auth, qiniuSDKProperties.getAvatar(), url);
    }

    private void deleteFile(Auth auth, QiniuBucket type, String url) {
        if (StringUtils.isBlank(url)) {
            return;
        }
        BucketManager manager = new BucketManager(auth);
        String filename = getFilenameFromUrl(url);
        try {
            manager.delete(type.getName(), filename);
        } catch (Exception e) {
        }
    }

    public Auth auth() {
        return Auth.create(qiniuSDKProperties.getAccessKey(), qiniuSDKProperties.getSecretKey());
    }

    private String getFilenameFromUrl(String url) {
        int index = url.lastIndexOf("/");
        return url.substring(index + 1);
    }
}
