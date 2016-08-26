package com.jusbilee.app.user.relationship.service.impl;

import com.jusbilee.app.mybatis.dao.UserFriendMapper;
import com.jusbilee.app.mybatis.pojo.UserFriend;
import com.jusbilee.app.mybatis.pojo.UserFriendCriteria;
import com.jusbilee.app.user.account.dao.AppUserDao;
import com.jusbilee.app.user.relationship.dao.UserRelationshipDao;
import com.jusbilee.app.user.relationship.domain.UserFriendProfile;
import com.jusbilee.app.user.relationship.service.IUserRelationshipService;
import com.rockit.core.Constants;
import com.rockit.core.exception.UserNotExistsException;
import com.rockit.qcloud.im.signature.TLSSignatureGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/8/2.
 */
@Service
public class UserRelationshipService implements IUserRelationshipService {
    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private UserFriendMapper userFriendMapper;

    @Autowired
    private UserRelationshipDao userRelationshipDao;

    @Autowired
    private TLSSignatureGenerator signatureGenerator;

    @Override
    @Transactional
    public void addFriend(Long userId, Long friendId) throws UserNotExistsException {
        if (userId.equals(friendId)) {
            return;
        }

        if (isFriend(userId, friendId)) {
            return;
        }

        Long fid = appUserDao.checkExistsById(friendId);
        if (fid == null) {
            throw new UserNotExistsException();
        }

        UserFriend friend = new UserFriend();
        friend.setUserId(userId);
        friend.setFriendUserId(friendId);
        friend.setCreateTime(new Date());
        userFriendMapper.insertSelective(friend);

        friend.setUserId(friendId);
        friend.setFriendUserId(userId);
        userFriendMapper.insertSelective(friend);

        appUserDao.increaseUserFriend(userId);
        appUserDao.increaseUserFriend(friendId);
    }

    @Override
    public void deleteFriend(Long userId, Long friendId) {
        UserFriendCriteria criteria = new UserFriendCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId).andFriendUserIdEqualTo(friendId);

        UserFriend friend = new UserFriend();
        friend.setIsDeleted(Constants.BOOL.YES);
        userFriendMapper.updateByExampleSelective(friend, criteria);

        criteria = new UserFriendCriteria();
        criteria.createCriteria().andUserIdEqualTo(friendId).andFriendUserIdEqualTo(userId);
        userFriendMapper.updateByExampleSelective(friend, criteria);

        appUserDao.decreaseUserFriend(userId);
        appUserDao.decreaseUserFriend(friendId);
    }

    @Override
    public List<UserFriendProfile> getAllFriends(Long userId) {
        List<UserFriendProfile> friends = userRelationshipDao.getAllFriends(userId);
        if (!friends.isEmpty()) {
            for (UserFriendProfile profile : friends) {
                profile.setIdentifier(signatureGenerator.getIdentifier(profile.getUserId()));
            }
        }
        return friends;
    }

    @Override
    public boolean isFriend(Long userId, Long friendId) {
        UserFriendCriteria criteria = new UserFriendCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId).andFriendUserIdEqualTo(friendId).andIsDeletedEqualTo(Constants.BOOL.NO);
        return userFriendMapper.selectByExample(criteria).size() > 0;
    }

    @Override
    public long getUserFriendCount(Long userId) {
        UserFriendCriteria criteria = new UserFriendCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(Constants.BOOL.NO);
        return userFriendMapper.countByExample(criteria);
    }
}
