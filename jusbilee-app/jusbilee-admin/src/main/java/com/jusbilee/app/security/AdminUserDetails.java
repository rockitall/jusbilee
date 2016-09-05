package com.jusbilee.app.security;

import com.jusbilee.app.mybatis.pojo.AdminUser;
import com.rockit.core.Constants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/8/4.
 */
public class AdminUserDetails implements UserDetails {
    private AdminUser adminUser;

    public AdminUserDetails(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ADMIN"));
        return list;
    }


    @Override
    public String getPassword() {
        return adminUser.getPassword();
    }

    @Override
    public String getUsername() {
        return adminUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !Constants.BOOL.isTrue(adminUser.getIsLocked());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !Constants.BOOL.isTrue(adminUser.getIsDeleted());
    }

    public String getAddress() {
        return adminUser.getAddress();
    }

    public Date getCreateTime() {
        return adminUser.getCreateTime();
    }

    public String getEmail() {
        return adminUser.getEmail();
    }

    public Integer getId() {
        return adminUser.getId();
    }

    public Byte getIsAdmin() {
        return adminUser.getIsAdmin();
    }

    public Byte getIsDeleted() {
        return adminUser.getIsDeleted();
    }

    public Byte getIsLocked() {
        return adminUser.getIsLocked();
    }

    public String getMobile() {
        return adminUser.getMobile();
    }

    public String getNickname() {
        return adminUser.getNickname();
    }

    public Date getUpdateTime() {
        return adminUser.getUpdateTime();
    }
}
