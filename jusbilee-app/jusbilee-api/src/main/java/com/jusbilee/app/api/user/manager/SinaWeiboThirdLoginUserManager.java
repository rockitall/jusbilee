package com.jusbilee.app.api.user.manager;

import com.fasterxml.jackson.databind.JsonNode;
import com.jusbilee.app.api.user.account.domain.SinaWeiboUser;
import com.jusbilee.app.api.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.api.user.account.service.ThirdUserLookupService;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.exception.InvalidAccessTokenException;
import com.rockit.core.exception.NetworkErrorException;
import com.rockit.core.http.HttpClientService;
import com.rockit.core.http.HttpRequest;
import com.rockit.core.http.HttpResponse;
import com.rockit.core.http.HttpRuntimeException;
import com.rockit.core.utils.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by allen on 16-1-24.
 */
@Service
public class SinaWeiboThirdLoginUserManager implements ThirdUserLookupService {
    private static final Logger logger = LoggerFactory.getLogger(SinaWeiboThirdLoginUserManager.class);

    @Value("${weibo.oauth2.userInfoUrl}")
    private String url;

    @Autowired
    private HttpClientService httpService;

    public SinaWeiboUser lookup(ThirdUserCredentials credentials) throws InvalidAccessTokenException {
        Assert.notNull(credentials, "sinaweibo credentials is null");
        try {
            HttpRequest request = HttpRequest.get(url);
            request.addUrlParameter("access_token", credentials.getAccessToken());
            request.addUrlParameter("uid", credentials.getOpenid());

            HttpResponse response = httpService.execute(request);
            JsonNode node = JacksonUtil.toJsonNode(response.getBody());
            if (logger.isDebugEnabled()) {
                logger.debug("sina weibo login result:{}", response.getBody());
            }
            if (node != null) {
                SinaWeiboUser user = JacksonUtil.toObject(node, SinaWeiboUser.class);
                if (user != null && StringUtils.isNotBlank(user.getOpenid())) {
                    return user;
                }
            }
        } catch (HttpRuntimeException e) {
            logger.error("sina weibo login error", e);
            throw new NetworkErrorException();
        } catch (Exception e) {
            logger.error("sina weibo login error", e);
            throw new BadCredentialsException();
        }
        throw new InvalidAccessTokenException();
    }

}
