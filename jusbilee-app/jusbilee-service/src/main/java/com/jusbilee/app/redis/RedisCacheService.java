package com.jusbilee.app.redis;

import com.jusbilee.app.api.user.account.domain.AccessToken;
import com.rockit.core.utils.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheService {
    private static final String USR_TOKEN_PREFIX = "login:token:";
    private static final String SMS_PREFIX = "sms:ssid:";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value, long timeout, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public String get(Object key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    public void setUserAccessToken(AccessToken token) {
        String userIdKey = USR_TOKEN_PREFIX + token.getUserId();
        String oldToken = this.get(userIdKey);
        if (StringUtils.isNoneBlank(oldToken)) {
            String oldTokenKey = USR_TOKEN_PREFIX + oldToken;
            this.delete(oldTokenKey);
        }

        String value = JacksonUtil.toJson(token);
        String key = USR_TOKEN_PREFIX + token.getUserToken();
        this.set(key, value, 30, TimeUnit.DAYS);
        this.set(userIdKey, token.getUserToken(), 30, TimeUnit.DAYS);
    }

    public AccessToken getUserAccessToken(String token) {
        String key = USR_TOKEN_PREFIX + token;
        String value = this.get(key);
        if (value != null) {
            return JacksonUtil.toObject(value, AccessToken.class);
        }
        return null;
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void deleteAccessToken(String userToken) {
        String key = USR_TOKEN_PREFIX + userToken;
        stringRedisTemplate.delete(key);
    }
}
