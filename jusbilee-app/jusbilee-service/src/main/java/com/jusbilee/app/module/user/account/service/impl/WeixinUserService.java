package com.jusbilee.app.module.user.account.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jusbilee.app.module.user.account.domain.WeixinUser;
import com.jusbilee.app.module.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.module.user.account.service.ThirdUserLookup;
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
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by allen on 16-1-24.
 */
@Service
public class WeixinUserService implements ThirdUserLookup {
    @Value("${weixin.oauth2.userInfoUrl}")
    private String weixinUrl;

    @Autowired(required = false)
    private HttpClientService httpService;

    public WeixinUser lookup(ThirdUserCredentials credentials) throws InvalidAccessTokenException, NetworkErrorException, BadCredentialsException {
        Assert.notNull(credentials, "weixin credentials is null");
        try {
            HttpRequest request = HttpRequest.get(weixinUrl);
            request.addUrlParameter("access_token", credentials.getAccessToken());
            request.addUrlParameter("openid", credentials.getOpenid());

            HttpResponse response = httpService.execute(request);
            JsonNode node = JacksonUtil.toJsonNode(response.getBody());
            if (node != null) {
                WeixinUser user = JacksonUtil.toObject(node, WeixinUser.class);
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
}
