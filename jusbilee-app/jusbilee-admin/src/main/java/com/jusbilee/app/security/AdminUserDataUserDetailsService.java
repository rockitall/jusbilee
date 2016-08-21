package com.jusbilee.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.SysUserDao;
import com.jusbilee.app.admin.domain.SysUser;

/**
 * Created by Allen on 2016/8/3.
 */
@Service
public class AdminUserDataUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserDao.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return new AdminUserDetails(user);
    }
}
