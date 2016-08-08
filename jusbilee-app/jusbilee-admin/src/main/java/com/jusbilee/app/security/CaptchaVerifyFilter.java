package com.jusbilee.app.security;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter
public class CaptchaVerifyFilter extends OncePerRequestFilter {
    private static final String VERIFY_CODE = "verifyCode_sesion";

    private Logger logger = LoggerFactory.getLogger(CaptchaVerifyFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String verifyCode = request.getParameter("verifyCode");
        String _sessionVerifyCode = (String) request.getSession().getAttribute(VERIFY_CODE);
        if (!StringUtils.equals(verifyCode, _sessionVerifyCode)) {
            response.sendRedirect("/admin/login?error");
        }
    }
}