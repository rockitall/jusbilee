package com.jusbilee.app.module.user.relationship.dao;

import com.jusbilee.app.module.user.relationship.domain.UserFriendProfile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Allen on 2016/8/22.
 */
public interface UserRelationshipDao {
    @Select("select u.id as userId, u.nickname, u.avatar from t_app_user u, t_user_friend f where f.friend_user_id=u.id and f.user_id=#{userId} and f.is_deleted=0")
    List<UserFriendProfile> getAllFriends(@Param("userId") Long userId);
}
