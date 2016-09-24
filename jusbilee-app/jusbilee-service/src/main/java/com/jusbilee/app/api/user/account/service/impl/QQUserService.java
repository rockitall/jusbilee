package com.jusbilee.app.api.user.account.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jusbilee.app.api.user.account.domain.QQUser;
import com.jusbilee.app.api.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.api.user.account.service.ThirdUserLookup;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.exception.InvalidAccessTokenException;
import com.rockit.core.exception.NetworkErrorException;
import com.rockit.core.http.HttpClientService;
import com.rockit.core.http.HttpRequest;
import com.rockit.core.http.HttpResponse;
import com.rockit.core.http.HttpRuntimeException;
import com.rockit.core.utils.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

/**
 * Created by Allen on 2016/9/24.
 */
public class QQUserService implements ThirdUserLookup {
    @Value("${qq.oauth2.userInfoUrl}")
    private String userInfoUrl;

    @Value("${qq.oauth2.appid}")
    private String appid;

    @Autowired(required = false)
    private HttpClientService httpService;

    public QQUser lookup(ThirdUserCredentials credentials) throws InvalidAccessTokenException, NetworkErrorException, BadCredentialsException {
        Assert.notNull(credentials, "qq credentials is null");
        try {
            HttpRequest request = HttpRequest.get(this.userInfoUrl);
            request.addUrlParameter("access_token", credentials.getAccessToken());
            request.addUrlParameter("openid", credentials.getOpenid());
            request.addUrlParameter("oauth_consumer_key", appid);

            HttpResponse response = httpService.execute(request);
            JsonNode node = JacksonUtil.toJsonNode(response.getBody());
            if (node != null) {
                QQUser user = JacksonUtil.toObject(node, QQUser.class);
                if (StringUtils.isNotBlank(user.getOpenid())) {
                    return user;
                }
            }
        } catch (HttpRuntimeException e) {
            throw new NetworkErrorException();
        } catch (Exception e) {
            throw new BadCredentialsException();
        }
        throw new InvalidAccessTokenException();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
