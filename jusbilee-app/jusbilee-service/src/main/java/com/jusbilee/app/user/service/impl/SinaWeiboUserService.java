package com.jusbilee.app.user.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jusbilee.app.common.exception.BadCredentialsException;
import com.jusbilee.app.common.exception.InvalidAccessTokenException;
import com.jusbilee.app.common.exception.NetworkErrorException;
import com.jusbilee.app.common.utils.JacksonUtil;
import com.jusbilee.app.user.param.ThirdUserCredentials;
import com.jusbilee.app.user.domain.SinaWeiboUser;
import com.jusbilee.app.user.service.ThirdUserLookup;
import com.rockit.core.http.HttpClientService;
import com.rockit.core.http.HttpRequest;
import com.rockit.core.http.HttpResponse;
import com.rockit.core.http.HttpRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by allen on 16-1-24.
 */
@Service
public class SinaWeiboUserService implements ThirdUserLookup {
    @Value("${weibo.oauth2.userInfoUrl}")
    private String url;

    @Autowired(required = false)
    private HttpClientService httpService;

    public SinaWeiboUser lookup(ThirdUserCredentials credentials) throws InvalidAccessTokenException {
        Assert.notNull(credentials, "sinaweibo credentials is null");
        try {
            HttpRequest request = HttpRequest.get(url);
            request.addUrlParameter("access_token", credentials.getAccessToken());
            request.addUrlParameter("uid", credentials.getOpenid());

            HttpResponse response = httpService.execute(request);
            JsonNode node = JacksonUtil.toJsonNode(response.getBody());
            if (node != null) {
                SinaWeiboUser user = JacksonUtil.toObject(node, SinaWeiboUser.class);
                if (user != null && StringUtils.isNotBlank(user.getOpenid())) {
                    return user;
                }
                return user;
            }
        } catch (HttpRuntimeException e) {
            throw new NetworkErrorException();
        } catch (Exception e) {
            throw new BadCredentialsException();
        }
        throw new InvalidAccessTokenException();
    }

}
