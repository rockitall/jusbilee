package com.jusbilee.app.api.user.manager;

import com.fasterxml.jackson.databind.JsonNode;
import com.jusbilee.app.api.user.account.domain.QQUser;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by Allen on 2016/9/24.
 */
@Service
public class QQThirdLoginUserManager implements ThirdUserLookupService {
    private static final Logger logger = LoggerFactory.getLogger(QQThirdLoginUserManager.class);
    @Value("${qq.oauth2.userInfoUrl}")
    private String userInfoUrl;

    @Value("${qq.oauth2.appid}")
    private String appid;

    @Autowired
    private HttpClientService httpService;

    public QQUser lookup(ThirdUserCredentials credentials) throws InvalidAccessTokenException, NetworkErrorException, BadCredentialsException {
        Assert.notNull(credentials, "qq credentials is null");
        try {
            HttpRequest request = HttpRequest.get(this.userInfoUrl);
            request.addUrlParameter("access_token", credentials.getAccessToken());
            request.addUrlParameter("openid", credentials.getOpenid());
            request.addUrlParameter("oauth_consumer_key", appid);

            HttpResponse response = httpService.execute(request);
            if (logger.isDebugEnabled()) {
                logger.debug("qq login result:{}", response.getBody());
            }
            JsonNode node = JacksonUtil.toJsonNode(response.getBody());
            if (node != null) {
                QQUser user = JacksonUtil.toObject(node, QQUser.class);
                if (user != null || user.getCode() != null || user.getCode() == 0) {
                    user.setOpenid(credentials.getOpenid());
                    return user;
                }
            }
        } catch (HttpRuntimeException e) {
            logger.error("qq login error", e);
            throw new NetworkErrorException();
        } catch (Exception e) {
            logger.error("qq login error", e);
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
