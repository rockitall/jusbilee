package com.jusbilee.app.admin.service;

import com.jusbilee.app.admin.criteria.AdminUserQueryCriteria;
import com.jusbilee.app.admin.dao.AdminUserDao;
import com.jusbilee.app.admin.domain.AdminUserListItem;
import com.jusbilee.app.mybatis.dao.AdminUserMapper;
import com.jusbilee.app.mybatis.pojo.AdminUser;
import com.jusbilee.app.mybatis.pojo.AdminUserCriteria;
import com.rockit.core.Constants;
import com.rockit.core.exception.UserAlreadyExistsException;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/9/5.
 */
@Service
public class AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;
    @Autowired
    private AdminUserMapper adminUserMapper;

    public List<AdminUserListItem> queryAdminUser(AdminUserQueryCriteria criteria, Pagination pagination) {
        return adminUserDao.query(criteria, pagination);
    }

    public long countAdminUser(AdminUserQueryCriteria criteria) {
        return adminUserDao.count(criteria);
    }

    public void updateUserLockedStatus(Integer userId, Byte lockedStatus) {
        AdminUser user = new AdminUser();
        user.setId(userId);
        user.setIsLocked(lockedStatus);
        adminUserMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteAdminUser(Integer userId) {
        AdminUser user = new AdminUser();
        user.setId(userId);
        user.setIsDeleted(Constants.BOOL.YES);
        adminUserMapper.updateByPrimaryKeySelective(user);
    }

    public void updateAdminUserByUserId(Integer userId, AdminUser user) {
        user.setId(userId);
        adminUserMapper.updateByPrimaryKeySelective(user);
    }

    public AdminUser getAdminUserByUsername(String username) {
        AdminUserCriteria criteria = new AdminUserCriteria();
        criteria.createCriteria().andUsernameEqualTo(username).andIsDeletedEqualTo(Constants.BOOL.NO);
        List<AdminUser> users = adminUserMapper.selectByExample(criteria);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    public void addAdminUser(AdminUser user) throws UserAlreadyExistsException {
        AdminUser existsUser = getAdminUserByUsername(user.getUsername());
        if (existsUser != null) {
            throw new UserAlreadyExistsException();
        }
        user.setCreateTime(new Date());
        adminUserMapper.insertSelective(user);
    }

    public AdminUser getAdminUserById(Integer userId) {
        return adminUserMapper.selectByPrimaryKey(userId);
    }
}
