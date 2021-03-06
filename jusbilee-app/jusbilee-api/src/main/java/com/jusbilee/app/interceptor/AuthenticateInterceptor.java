package com.jusbilee.app.interceptor;

import com.jusbilee.app.api.user.account.domain.AccessToken;
import com.jusbilee.app.context.HttpContext;
import com.jusbilee.app.redis.RedisCacheService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticateInterceptor implements HandlerInterceptor {
    private RedisCacheService redisCacheService;

    public AuthenticateInterceptor(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpContext ctx = HttpContext.current();
        ctx.setApiKey(request.getParameter("apiKey"));
        ctx.setApiSign(request.getParameter("apiSign"));
        ctx.setTimestamp(request.getParameter("timestamp"));
        ctx.setPlatform(request.getParameter("platform"));
        ctx.setVersion(request.getParameter("version"));
        ctx.setUserToken(request.getParameter("userToken"));
        ctx.setDevice(request.getParameter("device"));
        ctx.setClientIp(request.getRemoteAddr());

        //set user token and userId
        if (StringUtils.isNotBlank(ctx.getUserToken())) {
            AccessToken token = redisCacheService.getUserAccessToken(ctx.getUserToken());
            if (token != null) {
                ctx.setUserId(token.getUserId());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}