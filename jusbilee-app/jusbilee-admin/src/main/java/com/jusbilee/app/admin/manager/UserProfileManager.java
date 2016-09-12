package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.request.AdminUserPasswordModifyRequest;
import com.jusbilee.app.admin.service.AdminUserService;
import com.jusbilee.app.security.AdminUserDetails;
import com.rockit.core.exception.BadCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Allen on 2016/9/12.
 */
@Service
public class UserProfileManager {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminUserService adminUserService;

    public void modifyPassword(AdminUserDetails details, AdminUserPasswordModifyRequest request) {
        if (details == null) {
            return;
        }
        String pwd = details.getPassword();
        if (!passwordEncoder.matches(request.getOldUserPassword(), pwd)) {
            throw new BadCredentialsException();
        }
        String newPassword = passwordEncoder.encode(request.getUserPassword());
        adminUserService.updateAdminUserPassword(details.getId(), newPassword);
        details.setPassword(newPassword);
    }
}
