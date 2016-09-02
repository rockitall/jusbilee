package com.jusbilee.app.qiniu;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Allen on 2016/9/2.
 */
public class UploadFileNameUtils {
    private static final char DELIMITER = '-';
    private static final char DOT = '.';
    private static final String HTTP_PROTOCOL = "http://";

    public static final String getUploadSN() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + DELIMITER + new Random().nextInt(1000000);
    }

    public static String getUploadFilename(String originalFilename, String bucket, String type, String sn) {
        int index = originalFilename.lastIndexOf(DOT);
        String ext = "";
        if (index > 0) {
            ext = originalFilename.substring(index);
        }
        StringBuilder buf = new StringBuilder(32);
        buf.append(bucket);
        buf.append(DELIMITER);
        if (StringUtils.isNoneBlank(type)) {
            buf.append(type);
            buf.append(DELIMITER);
        }
        buf.append(sn);
        buf.append(ext);
        return buf.toString();
    }

    public static String getUploadUrl(String domain, String filename) {
        StringBuilder buf = new StringBuilder(32);
        buf.append(HTTP_PROTOCOL);
        buf.append(domain);
        buf.append("/");
        buf.append(filename);
        return buf.toString();
    }
}
