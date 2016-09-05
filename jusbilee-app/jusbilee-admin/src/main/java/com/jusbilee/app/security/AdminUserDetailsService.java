package com.jusbilee.app.security;

import com.jusbilee.app.admin.service.AdminUserService;
import com.jusbilee.app.mybatis.pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Allen on 2016/8/3.
 */
@Service
public class AdminUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminUserService adminUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser user = adminUserService.getAdminUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return new AdminUserDetails(user);
    }
}
