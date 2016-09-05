package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.criteria.AdminUserQueryCriteria;
import com.jusbilee.app.admin.domain.AdminUserListItem;
import com.jusbilee.app.admin.request.AdminUserRequest;
import com.jusbilee.app.admin.service.AdminUserService;
import com.jusbilee.app.mybatis.pojo.AdminUser;
import com.rockit.core.Constants;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/9/5.
 */
@Service
public class AdminUserManager {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<AdminUserListItem> queryAdminUser(AdminUserQueryCriteria criteria, Pagination pagination) {
        return adminUserService.queryAdminUser(criteria, pagination);
    }

    public long countAdminUser(AdminUserQueryCriteria criteria) {
        return adminUserService.countAdminUser(criteria);
    }

    public AdminUser addAdminUser(AdminUserRequest request) {
        AdminUser user = transformToAdminUser(request);
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        adminUserService.addAdminUser(user);
        return user;
    }

    public void updateAdminUser(Integer userId, AdminUserRequest request) {
        AdminUser user = transformToAdminUser(request);
        adminUserService.updateAdminUserByUserId(userId, user);
    }

    private AdminUser transformToAdminUser(AdminUserRequest request) {
        AdminUser user = new AdminUser();
        user.setNickname(request.getNickname());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        if (request.getIsAdmin() == null) {
            user.setIsAdmin(Constants.BOOL.NO);
        } else {
            user.setIsAdmin(Constants.BOOL.YES);
        }
        return user;
    }

    public AdminUser getAdminUser(Integer userId) {
        return adminUserService.getAdminUserById(userId);
    }

    public void deleteAdminUser(Integer userId) {
        adminUserService.deleteAdminUser(userId);
    }

    public void lockAdminUser(Integer userId) {
        adminUserService.updateUserLockedStatus(userId, Constants.BOOL.YES);
    }

    public void unlockAdminUser(Integer userId) {
        adminUserService.updateUserLockedStatus(userId, Constants.BOOL.NO);
    }

}
