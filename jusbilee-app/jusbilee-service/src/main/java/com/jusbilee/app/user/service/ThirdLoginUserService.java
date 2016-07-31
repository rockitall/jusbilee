package com.jusbilee.app.user.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.jusbilee.app.common.exception.InvalidAccessTokenException;
import com.jusbilee.app.common.utils.JacksonUtil;
import com.jusbilee.app.user.param.ThirdUserCredentials;
import com.jusbilee.app.user.pojo.SinaWeiboUser;
import com.jusbilee.app.user.pojo.WeixinUser;
import com.rockit.core.http.HttpClientService;
import com.rockit.core.http.HttpRequest;
import com.rockit.core.http.HttpResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by allen on 16-1-24.
 */
@Service
public class ThirdLoginUserService {
    @Value("${oauth2.weibo.url}")
    private String weiboUrl;

    @Value("${oauth2.weixin.url}")
    private String weixinUrl;

    @Autowired
    private HttpClientService httpService;

    public SinaWeiboUser getSinaWeiboUserInfo(ThirdUserCredentials credentials) throws InvalidAccessTokenException {
        Assert.notNull(credentials, "sinaweibo credentials is null");

        HttpRequest request = HttpRequest.get(weiboUrl);
        request.addUrlParameter("access_token", credentials.getAccessToken());
        request.addUrlParameter("uid", credentials.getUserId());

        HttpResponse response = httpService.execute(request);
        JsonNode node = JacksonUtil.toJsonNode(response.getBody());
        if (node != null) {
            SinaWeiboUser user = JacksonUtil.toObject(node, SinaWeiboUser.class);
            if (user.getUserId() > 0) {
                return user;
            }
        }
        throw new InvalidAccessTokenException();
    }


    public WeixinUser getWeixinUserInfo(ThirdUserCredentials credentials) throws InvalidAccessTokenException {
        Assert.notNull(credentials, "weixin credentials is null");

        HttpRequest request = HttpRequest.get(weixinUrl);
        request.addUrlParameter("access_token", credentials.getAccessToken());
        request.addUrlParameter("openid", credentials.getUserId());

        HttpResponse response = httpService.execute(request);
        JsonNode node = JacksonUtil.toJsonNode(response.getBody());
        if (node != null) {
            WeixinUser user = JacksonUtil.toObject(node, WeixinUser.class);
            if (StringUtils.isNotBlank(user.getOpenId())) {
                return user;
            }
        }

        throw new InvalidAccessTokenException();
    }
}
