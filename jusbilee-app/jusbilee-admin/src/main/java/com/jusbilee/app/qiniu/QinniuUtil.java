/**
 * zhandc 2016年8月26日
 */
package com.jusbilee.app.qiniu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jusbilee.app.admin.request.SongRequests;
import com.jusbilee.app.mybatis.pojo.Song;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.rockit.core.exception.QiniuUploadEXception;

/**
 * @author zhandc 2016年8月26日
 *
 */

@Service
public class QinniuUtil {

	@Autowired
	private QiniuSDKProperties qiniuSDKProperties;

	public void uploadSong(SongRequests.SongParam param) throws QiniuUploadEXception {
		upload(param.getIconUrl());
		upload(param.getOpernScreenshotUrl());
		upload(param.getOpernUrl());
		upload(param.getWavPlayUrl());
		upload(param.getMidiPlayUrl());
	}
	
	public void getDownloadUrl(Song song){
		song.setIconUrl(getDownLoadURL(song.getIconUrl()));
		song.setOpernScreenshotUrl(getDownLoadURL(song.getOpernScreenshotUrl()));
		song.setOpernUrl(getDownLoadURL(song.getOpernUrl()));
		song.setWavPlayUrl(getDownLoadURL(song.getWavPlayUrl()));
		song.setMidiPlayUrl(getDownLoadURL(song.getMidiPlayUrl()));
	}

	public void deleteSong(Song song) {
		delete(song.getIconUrl());
		delete(song.getOpernScreenshotUrl());
		delete(song.getOpernUrl());
		delete(song.getWavPlayUrl());
		delete(song.getMidiPlayUrl());
	}

	private void upload(MultipartFile file) throws QiniuUploadEXception {
		Auth auth = Auth.create(qiniuSDKProperties.getAccessKey(), qiniuSDKProperties.getSecretKey());
		String token = auth.uploadToken(qiniuSDKProperties.getBucketName(), file.getOriginalFilename());
		UploadManager uploadManager = new UploadManager();
		try {
			uploadManager.put(file.getBytes(), file.getOriginalFilename(), token);
		} catch (Exception e) {
			e.printStackTrace();
			throw new QiniuUploadEXception();
		}

	}

	private String getDownLoadURL(String key) {
		Auth auth = Auth.create(qiniuSDKProperties.getAccessKey(), qiniuSDKProperties.getSecretKey());
		return auth.privateDownloadUrl(qiniuSDKProperties.getUrl(), 3600);
	}

	private void delete(String key) {
		Auth auth = Auth.create(qiniuSDKProperties.getAccessKey(), qiniuSDKProperties.getSecretKey());
		BucketManager bucketManager = new BucketManager(auth);
		try {
			bucketManager.delete(qiniuSDKProperties.getBucketName(), key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
