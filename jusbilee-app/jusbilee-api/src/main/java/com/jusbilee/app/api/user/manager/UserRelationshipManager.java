package com.jusbilee.app.api.user.manager;

import com.jusbilee.app.api.user.relationship.domain.UserFriendProfile;
import com.jusbilee.app.api.user.relationship.service.UserRelationshipService;
import com.rockit.core.exception.UserNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/8/2.
 */
@Service
public class UserRelationshipManager {
    @Autowired
    private UserRelationshipService userRelationshipService;

    public void addFriend(Long userId, Long friendId) throws UserNotExistsException {
        userRelationshipService.addFriend(userId, friendId);
    }

    public void deleteFriend(Long userId, Long friendId) {
        userRelationshipService.deleteFriend(userId, friendId);
    }

    public List<UserFriendProfile> getAllFriends(Long userId) {
        return userRelationshipService.getAllFriends(userId);
    }

    public boolean isFriend(Long userId, Long friendId) {
        return userRelationshipService.isFriend(userId, friendId);
    }

    public long getUserFriendCount(Long userId) {
        return userRelationshipService.getUserFriendCount(userId);
    }
}
