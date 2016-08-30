package com.jusbilee.app.api.user.relationship.service;

import com.jusbilee.app.api.user.relationship.domain.UserFriendProfile;
import com.rockit.core.exception.UserNotExistsException;

import java.util.List;

/**
 * Created by Allen on 2016/8/2.
 */
public interface IUserRelationshipService {
    void addFriend(Long userId, Long friendId) throws UserNotExistsException;

    void deleteFriend(Long userId, Long friendId);

    List<UserFriendProfile> getAllFriends(Long userId);

    boolean isFriend(Long userId, Long friendId);

    long getUserFriendCount(Long userId);
}
